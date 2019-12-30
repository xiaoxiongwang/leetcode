/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;

        boolean b1 = isSameTree(p.left, q.left);
        boolean b2 = (p.val==q.val);
        boolean b3 = isSameTree(p.right, q.right);

        return b1&&b2&&b3;

        
    }
}
// @lc code=end

