/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        // int total =0;
        // for(int i=0;i<n;i++){
            // int left = numTrees(i-1);
        // }
        int total = middle(1, n);
        return total;   
    }
    public static int middle(int start,int end){
        int total = 0;
        if(start>end) return 1;
        else if(start==end) return 1;
        else if(end-start==1) return 2;
        
        for(int i=start;i<=end;i++){
            int left = middle(start, i-1);
            int right = middle(i+1, end);
            total += left*right;
        }
        return total;
    }
}
// @lc code=end

