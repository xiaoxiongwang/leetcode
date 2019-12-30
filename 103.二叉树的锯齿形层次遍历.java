/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root==null) return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int size = queue.size();
        boolean flag = true;
        while(size>0){
            LinkedList<Integer> queue_stack=new LinkedList<Integer>();
            while(size>0){
                TreeNode cur = queue.pop();
                if(flag){
                    queue_stack.add(cur.val);
                }else{
                    queue_stack.push(cur.val);
                }
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
                size--;
            }
            result.add(queue_stack);
            flag = !flag;
            size = queue.size();
        }
        return result;
    }
}
// @lc code=end

