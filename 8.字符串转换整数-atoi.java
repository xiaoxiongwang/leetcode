/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */
class Solution {
    public int myAtoi(String str) {
        String result = str.trim();
        char start = result.charAt(0);
        if(start!='+'||start!='-'||Character.isDigit(start)) return 0;
        
    }
}

