import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    private HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        for(int i=0;i<len;i++){
            map.put(inorder[i],i);
        }
        return buildTreeMiddle(inorder,postorder,0,len-1,len-1);
    }
    public TreeNode buildTreeMiddle(int[] inorder, int[] postorder,int i,int j,int r){
        if(i>j) return null;
        TreeNode root = new TreeNode(postorder[r]);
        if(i==j) return root;

        int pre_root = map.get(postorder[r]);   
        root.left = buildTreeMiddle(inorder,postorder,i,pre_root-1,r-(j-pre_root+1));
        root.right = buildTreeMiddle(inorder,postorder,pre_root+1,j,r-1);

        return root;
    }
}
// @lc code=end

