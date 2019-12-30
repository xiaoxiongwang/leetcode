import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public static boolean BSTvaild(TreeNode root,TreeNode min,TreeNode max){
        if(root==null) return true;
        if(min!=null)
            if(min.val>=root.val) return false;
        if(max!=null)
            if(max.val<=root.val) return false;

        return BSTvaild(root.left, min, root) && BSTvaild(root.right,root,max);
    }
    public boolean isValidBST(TreeNode root) {
        return BSTvaild(root, null, null);
        // if(root==null) return true;

        // LinkedList<TreeNode> result = new LinkedList<TreeNode>();
        // LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();

        // HashMap<TreeNode,Integer> node2min = new HashMap<TreeNode,Integer>();
        // HashMap<TreeNode,Integer> node2max = new HashMap<TreeNode,Integer>();

        // tmp.add(root);

        // while(!tmp.isEmpty()){
        //     TreeNode cur = tmp.pop();
        //     result.push(cur);
        //     node2min.put(cur, cur.val);
        //     node2max.put(cur, cur.val);

        //     if(cur.left!=null){
        //         tmp.add(cur.left);
        //     }

        //     if(cur.right!=null){
        //         tmp.add(cur.right);
        //     }
        // }
        // // System.out.println(result.get(0).val);
        // // System.out.println(result.get(1).val);


        // while(!result.isEmpty()){
        //     TreeNode cur = result.pop();
        //     // System.out.println(cur.val);
        //     if(cur.left!=null){
        //         System.out.println("max:"+node2max.get(cur.left)+" cur"+cur.val);

        //         if(node2max.get(cur.left)>=cur.val){
        //             // System.out.println("test");
        //             return false;
        //         }
        //         node2min.put(cur,node2max.get(cur.left));
        //     }

        //     if(cur.right!=null){
        //         System.out.println("min:"+node2min.get(cur.right)+" cur"+cur.val);
        //         if(node2min.get(cur.right)<=cur.val){
        //             // System.out.println("min:"+node2min.get(cur));
        //             // System.out.println("test2");
        //             return false;
        //         }
        //         node2max.put(cur, node2max.get(cur.right));
        //     }

            
        //     // if((cur.left!=null&&cur.left.val>=cur.val)||(cur.right!=null&&cur.right.val<=cur.val)){
        //         // return false;
        //     // }
        // }
        // return true;
    }
}
// @lc code=end

