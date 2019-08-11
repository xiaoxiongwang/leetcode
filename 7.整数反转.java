import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */
class Solution {
    public int reverse(int x) {
        if(x==Integer.MIN_VALUE) return 0;
        int sign = x<0?-1:1;
        if(sign==-1) x=-x;
        long result = 0;
        while(x!=0)
        {
            result = result*10 + x%10;
            x /= 10;
        }
        if(result>=Integer.MAX_VALUE) return 0;
        return (int)result*sign;
    }
}

