import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    public void recoverTree(TreeNode root) {
        LinkedList<TreeNode> result = new LinkedList<TreeNode>();
        // result.push(root);
        TreeNode head = root;
        TreeNode pre = null,record = null,second=null;
        while(true){
            if(head!=null){
                result.push(head);
                head = head.left;
            }else{
                if(result.isEmpty()) break;
                TreeNode cur = result.pop();
                if(pre!=null){
                    if(pre.val>cur.val){
                        if(record==null){
                            record = pre;
                            // System.out.println("record");
                            System.out.println(record.val);
                        }
                        second = cur;
                        // System.out.println("second");
                        System.err.println(second.val);
                    }
                }
                pre = cur;

                head = cur.right;
                
            }
        }
        int m = record.val;
        record.val = second.val;
        second.val = m;
    }
}
// @lc code=end

