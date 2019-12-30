/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode cur = head.next,pre=head;
        int pre_val = head.val;
        while(cur!=null){
            if(cur.val==pre_val){
                pre.next = cur.next;
            }else{
                pre = cur;
                pre_val = pre.val;
            }

            cur = cur.next;
        }
        return head;
    }
}
// @lc code=end

