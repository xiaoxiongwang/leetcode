import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public static boolean isSymmetric_middle(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        boolean b1 = (left.val==right.val);
        boolean b2 = isSymmetric_middle(left.left, right.right);
        boolean b3 = isSymmetric_middle(left.right,right.left);
        // boolean b4 = isSymmetric_middle(left.left, left.right);
        // boolean b5 = isSymmetric_middle(right.left, right.right);

        return b1&&b2&&b3;

    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric_middle(root.left,root.right);
        
    }

}
// @lc code=end

