import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root==null) return result;
        LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
        tmp.add(root);

        while(!tmp.isEmpty()){
            LinkedList<Integer> middle_result = new LinkedList<Integer>();
            int size = tmp.size();
            while(size>0){
                TreeNode cur = tmp.pop();
                middle_result.add(cur.val);
                if(cur.left!=null) tmp.add(cur.left);
                if(cur.right!=null) tmp.add(cur.right);
                size--;
            }
            result.push(middle_result);
        }
        return result;
    }
}
// @lc code=end

