/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // int d[] = new int[n+1];
        int a=1;
        int b=1;
        for(int i=2;i<=n;i++){
            int c = a+b;
            a=b;
            b=c;
        }
        return b;
        // Time Limit Exceeded
        // if(n==0||n==1) return 1;
        // else return climbStairs(n-1)+climbStairs(n-2);   
    }
}
// @lc code=end

