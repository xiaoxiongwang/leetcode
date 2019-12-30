import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root==null) return result;
        LinkedHashMap<TreeNode,Integer> tmp = new LinkedHashMap<TreeNode,Integer>();
        tmp.put(root,0);

        LinkedList<TreeNode> middle = new LinkedList<TreeNode>();
        middle.add(root);

        while(!middle.isEmpty()){
            TreeNode cur = middle.pop();
            Integer cur_level = tmp.get(cur);
            if(cur_level+1>result.size()){
                result.add(new LinkedList<Integer>());
            }
            result.get(cur_level).add(cur.val);

            if(cur.left!=null){
                tmp.put(cur.left,cur_level+1);
                middle.add(cur.left);
            }
            if(cur.right!=null){
                tmp.put(cur.right,cur_level+1);
                middle.add(cur.right);
            }
        }
        return result;
    }
}
// @lc code=end

