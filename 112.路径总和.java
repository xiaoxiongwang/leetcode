import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;

        LinkedList<TreeNode> result = new LinkedList<TreeNode>();
        // result.add(root);
        int h = 0;
        TreeNode head = root;
        HashSet<TreeNode> set = new HashSet<TreeNode>();

        while(head!=null||!result.isEmpty()){
            if(head!=null){

            }else{

            }
        }
        return false;


        //rescusion
        // return hasPathSum_middle(root,sum,0);
        
    }

    //rescusion
    // public static boolean hasPathSum_middle(TreeNode root,int sum,int middle){
    //     if(root==null) return false;

    //     if(root.left==null&&root.right==null) {
    //         if(sum==middle+root.val){
    //             return true;
    //         }else{
    //             return false;
    //         }
    //     }
    //     return hasPathSum_middle(root.left,sum,middle+root.val)||hasPathSum_middle(root.right,sum,middle+root.val);
    // }
}
// @lc code=end

