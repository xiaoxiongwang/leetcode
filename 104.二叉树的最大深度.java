import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
        TreeNode head = root;
        int level = 0;
        tmp.add(head);
        // int size = 1;
        while(!tmp.isEmpty()){
            level++;
            int size = tmp.size();
            // System.out.println(size);
            for(int i=0;i<size;i++){
                TreeNode cur = tmp.pop();
                if(cur.left!=null) tmp.add(cur.left);
                if(cur.right!=null) tmp.add(cur.right);
            }

        }
        return level;
    }
}
// @lc code=end

