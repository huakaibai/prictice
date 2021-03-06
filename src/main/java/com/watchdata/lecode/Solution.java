package com.watchdata.lecode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author zhibin.wang
 * @create 2019-11-19 9:43
 * @desc 算法刷题
 **/

public class Solution {

    @Test
    public void removeDuplicates() {
        String S = "abbaca";
        char[] chars = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        Stack<Character> stack = new Stack();

        for (char aChar : chars) {
            if (!stack.empty()) {
                Character peek = stack.peek();
                if (aChar != peek.charValue()) {
                    stack.push(aChar);
                } else {
                    stack.pop();
                }
            } else {
                stack.push(aChar);
            }
        }


        /*while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }*/
        stack.forEach(c->stringBuilder.append(c));
        System.out.println(stringBuilder.toString());

    }

    @Test
    public void backspaceCompare() {
        String S= "ab##";
        String T= "c#d#";
        char[] chars = S.toCharArray();
        char[] chars1 = T.toCharArray();
        for (int i=0;i< chars.length;i++){
            if (chars[i] == '#' && i>0){
                chars[i] = '0';
                chars[i-1] = '0';
            }else if (chars[i] == '#'){
                chars[i] = '0';
            }

        }
        for (int i=0;i< chars1.length;i++){
            if (chars1[i] == '#' && i>0){
                chars1[i] = '0';
                chars1[i-1] = '0';
            }else if (chars1[i] == '#') {
                chars1[i] = '0';
            }


        }
        System.out.println( String.valueOf(chars).replace("0","").equals(String.valueOf(chars1).replace("0","")));

    }

    public int longestMountain(int[] A) {

        for (int i=0;i<A.length;i++){

        }
return 1;

    }

    @Test
    public void removeOuterParentheses() {
        String S = "(()())((()))";
        StringBuilder stringBuilder = new StringBuilder();
        int make = -1;
        for (int i=0;i< S.length();i++){
            if (S.charAt(i) == '('){
                make++;
            }
            if (S.charAt(i) == ')'){
                make--;
            }
            if (make==0 && S.charAt(i) == '(' ||(make==-1 && S.charAt(i)== ')') ){
                continue;
            }
            stringBuilder.append(S.charAt(i));
        }

    /*    char[] chars = S.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        char left = '(';
        char right = ')';

        Stack<Character> stack = new Stack();
        int i = 1;
        for (char aChar : chars){
            if (!stack.empty()){
                Character peek = stack.peek();

                if (aChar == left){
                    if ( i != 1){
                        if (aChar == peek){
                            stack.pop();
                        }
                        i++;
                    }

                    stack.push(aChar);
                } else if (aChar == right){
                    i =1;
                    if (aChar == peek){
                        continue;
                    }else {
                        stack.push(aChar);
                    }
                }else {
                    stack.push(aChar);
                }
            }else {
                stack.push(aChar);
            }

        }
        stack.forEach(c->stringBuilder.append(c));
        System.out.println(stringBuilder.toString());*/
    }

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        char[] dest = new char[chars.length];
        System.arraycopy(chars,n,dest,0,chars.length-n);
        System.arraycopy(chars,0,dest,chars.length-n,n);
        System.out.println(dest);
        return String.valueOf(dest);
    }

    @Test
    public void testReverseLeftWords(){
        String abcdefg = reverseLeftWords("abcdefgdf", 3);
        System.out.println(abcdefg);
    }
}
