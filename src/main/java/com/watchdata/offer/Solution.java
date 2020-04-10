package com.watchdata.offer;

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
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int j = stack.size();

        int a[] = new int[stack.size()];
       for (int i = 0; i < j;i++ ){
           a[i] = stack.pop().val;
       }

       return a;

    }

    static class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

    /**
     * 题目描述： 输入某二叉树的前序遍历和中序遍历的结果， 请重建出该二叉树。 假
     * 设输入的前序遍历和中序遍历的结果中都不含重复的数字。 例如输入前序遍历序列
     * {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}， 则重建二叉树并返回。
     * 思路： 先找出根节点， 然后利用递归方法构造二叉树
     * 代码实现： 时间复杂度： O(n)， 空间复杂度： O(n)
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return relativeTreeNode(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

    }

    private static TreeNode relativeTreeNode(int[] pre,int preStart,int preEnd,int[] end,int endStart,int endEnd){
        if (preStart > preEnd || endStart > endEnd){
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        int index = endStart;
        while (index <= endEnd && end[index] != root.val){
            index++;
        }
        int length = index - endStart;

        root.left = relativeTreeNode(pre, preStart+1, preStart+length, end, endStart, index-1);
        root.right = relativeTreeNode(pre, preStart+length+1, preEnd, end, index+1, endEnd);
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
            if (head.isEmpty() && tail.isEmpty()){
                return -1;
            }
            while (!head.isEmpty()){
                tail.push(head.pop());
            }
            return (int) tail.pop();


        }
    }

    public static int minArray(int[] numbers) {

        for (int i= 0;i+1<numbers.length;i++){
            if (numbers[i] > numbers[i+1]){
                return numbers[i+1];
            }
        }
        return numbers[0];
    }



    public static int fib(int n) {
        if( n == 0 || n== 1){
            return 1;
        }

        return fib(n-1) + fib(n-2);

    }

    public static void main(String[] args) {
/*        int arr[][] = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(find2(arr, 5));*/


        int[] pre = {3,9,20,15,7};
        int[]end = {9,3,15,20,7};

    buildTree(pre, end);


    }
}
