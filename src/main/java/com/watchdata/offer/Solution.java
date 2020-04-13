package com.watchdata.offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhibin.wang
 * @desc 剑指offer算法题
 **/
public class Solution {


    /**
     * 题目描述： 在一个二维数组中， 每一行都按照从左到右递增的顺序排序， 每一列
     * 都按照从上到下递增的顺序排序。 请完成一个函数， 输入这样的一个二维数组和一
     * 个整数， 判断数组中是否含有该整数。
     * 思路： 从右上角或左下角开始找， 逐行排除，
     *
     * @param array  数组
     * @param target 查找得目标值
     * @return
     */
    public static boolean find1(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            }

            if (target > matrix[row][column]) {
                row++;
            } else {
                column--;
            }

        }
        return false;

    }

    /**
     * 二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean find2(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        int rowlength = matrix[0].length;
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = matrix[left / rowlength][left % rowlength];
            if (value == target) {
                return true;
            }
            if (value > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * 替换字符串中的空格
     * 题目描述： 将一个字符串中的空格替换成“%20”。 例如： 当字符串为 We Are
     * Happy.则经过替换之后的字符串为 We%20Are%20Happy。
     * 思路： 从后往前复制， 数组长度会增加， 或使用 StringBuilder、 StringBuffer 类
     *
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (String.valueOf(aChar).equals(" ")) {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 输入一个链表， 从尾到头打印链表每个节点的值。
     * 思路： 借助栈实现， 或使用递归的方法。
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int j = stack.size();

        int a[] = new int[stack.size()];
        for (int i = 0; i < j; i++) {
            a[i] = stack.pop().val;
        }

        return a;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 题目描述： 输入某二叉树的前序遍历和中序遍历的结果， 请重建出该二叉树。 假
     * 设输入的前序遍历和中序遍历的结果中都不含重复的数字。 例如输入前序遍历序列
     * {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}， 则重建二叉树并返回。
     * 思路： 先找出根节点， 然后利用递归方法构造二叉树
     * 代码实现： 时间复杂度： O(n)， 空间复杂度： O(n)
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return relativeTreeNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    private static TreeNode relativeTreeNode(int[] pre, int preStart, int preEnd, int[] end, int endStart, int endEnd) {
        if (preStart > preEnd || endStart > endEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        int index = endStart;
        while (index <= endEnd && end[index] != root.val) {
            index++;
        }
        int length = index - endStart;

        root.left = relativeTreeNode(pre, preStart + 1, preStart + length, end, endStart, index - 1);
        root.right = relativeTreeNode(pre, preStart + length + 1, preEnd, end, index + 1, endEnd);
        return root;
    }


    static class CQueue {

        Stack head;
        Stack tail;

        public CQueue() {
            head = new Stack();
            tail = new Stack();
        }

        public void appendTail(int value) {
            head.push(value);

        }

        public int deleteHead() {
            if (head.isEmpty() && tail.isEmpty()) {
                return -1;
            }
            while (!head.isEmpty()) {
                tail.push(head.pop());
            }
            return (int) tail.pop();


        }
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之为数组的
     * 旋转。 输入一个非递减排序的数组的一个旋转， 输出旋转数组的最小元素。 例如
     * 数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转， 该数组的最小值为 1。 NOTE： 给出的所
     * 有元素都大于 0， 若数组大小为 0， 请返回-1。 假设数组中不存在重复元素。
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {

        for (int i = 0; i + 1 < numbers.length; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
     * <p>
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */

    public int fib(int n) {
        int result = 0;
        int preOne = 1;
        int preTwo = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;

    }

    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int[] aa = new int[(int) Math.pow(10, n) - 1];
        for (int i = 1; i <= ((int) Math.pow(10, n) - 1); i++) {
            aa[i - 1] = i;
        }
        return aa;
    }

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * <p>
     * 返回删除后的链表的头节点。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode temp = head;
        ListNode up = null;
        while (temp != null) {
            if (temp.val == val) {
                break;
            }
            up = temp;
            temp = temp.next;

        }
        if (up == null) {
            head = head.next;
            return head;
        }
        if (temp.next != null) {
            up.next = temp.next;
        }

        return head;


    }

    /**
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * <p>
     * 1.1 算法描述
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     *
     * @param arr
     * @return
     */
    public int[] bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * <p>
     * 2.1 算法描述
     * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
     * <p>
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     *
     * @param arr
     * @return
     */
    public int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[max] < arr[j])
                    max = j;
            }
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
        return arr;

    }

    /**
     * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     *
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];

                } else {

                    break;
                }
            }
            arr[j + 1] = temp;

        }
        return arr;

    }

    /**
     * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     * <p>
     * 6.1 算法描述
     * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     * <p>
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * 6.2 动图演示
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static int[] quickSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return arr;
        }
        // 获取基准的位置
        int pivotIndex = getPivotIndex(arr, startIndex, endIndex);
        quickSort(arr, startIndex,pivotIndex-1);
        quickSort(arr, pivotIndex+1, endIndex);
        return arr;

    }

    public static int getPivotIndex(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = arr[startIndex];
        int index = startIndex;
        while (right  >= left) {
            while (right >= left) {
                if (arr[right] < pivot) {
                    arr[index] = arr[right];
                    arr[right] = pivot;
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            while (right >= left){
                if (arr[left] > pivot){
                    arr[index] = arr[left];
                    arr[left] = pivot;
                    index = left;
                    right--;
                    break;

                }
                left++;
            }


        }
        arr[index] = pivot;
        return index;

    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = arr[left];
    }


    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        // 坑的位置，初始等于pivot的位置
        int index = startIndex;

        //大循环在左右指针重合或者交错时结束
        while (right >= left) {
            //right指针从右向左进行比较
            while (right >= left) {
                if (arr[right] < pivot) {
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            //left指针从左向右进行比较
            while (right >= left) {
                if (arr[left] > pivot) {
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index] = pivot;
        return index;
    }

    public static void main(String[] args) {
/*        int arr[][] = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(find2(arr, 5));*/


      /*  int a[] = {2, 3, 1, 6, 8};
        int[] ints = insertionSort(a);
        for (int anInt : ints) {
            System.out.println(anInt);
        }*/


        int[] arr = new int[] {2, 3, 1, 6, 8};
        int[] ints = quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(ints));
        //buildTree(pre, end);


    }
}
