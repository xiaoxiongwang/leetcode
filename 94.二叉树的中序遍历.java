import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */
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
    public List<Integer> inorderTraversal(TreeNode root) {
        // if(root==null) return new ArrayList<Integer>();
        // List<Integer> list = new ArrayList<Integer>();
        // list.addAll(inorderTraversal(root.left));
        // list.add(root.val);
        // list.addAll(inorderTraversal(root.right));
        // return list;

        TreeNode head = root;
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(true){
            if(head!=null){
                stack.push(head);
                head = head.left;
            }else{
                if(stack.isEmpty()) break;
                TreeNode cur = stack.pop();
                // System.out.println(cur.val);
                result.add(cur.val);
                head = cur.right;
            }
        }
        return result;
    }
}

