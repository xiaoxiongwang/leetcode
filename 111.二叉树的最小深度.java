/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        LinkedList<TreeNode> tree = new LinkedList<TreeNode>();
        tree.add(root);
        int level = 0;
        while(!tree.isEmpty()){
            int size = tree.size();
            // System.out.println(size);
            level++;

            for(int i=0;i<size;i++){
                // System.out.println(level);
                TreeNode cur = tree.pop();
                // System.out.println(cur.val);
                if(cur.left==null&&cur.right==null){
                    // System.out.println("???");
                    return level;
                }
                if(cur.left!=null)
                    tree.add(cur.left);
                if(cur.right!=null)
                    tree.add(cur.right);
            }
        }   
        return level;
    }
}
// @lc code=end

