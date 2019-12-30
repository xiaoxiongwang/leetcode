import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public static List<TreeNode> generateTrees(int n) {
        if(n==0) return new LinkedList<TreeNode>();
        List<TreeNode> result = middle(1, n);
        return result;
    }
    public static List<TreeNode> middle(int start,int end){
        List<TreeNode> result = new LinkedList<TreeNode>();
        if(start>end){
            result.add(null);
            return result;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftnodes = middle(start, i-1);
            List<TreeNode> rightnodes = middle(i+1, end);
            // boolean flag1 = true;
            // boolean flag2 = true;
            for (TreeNode leftnode : leftnodes) {
                for (TreeNode rightnode : rightnodes) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftnode;
                    cur.right = rightnode;
                    result.add(cur);
                }
            }
        }
        return result;
    }
}
// @lc code=end

