/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        ListNode little = new ListNode(0);
        ListNode big = new ListNode(0);

        ListNode cur = head,cur_l = little,cur_b = big;

        while(cur!=null){
            if(cur.val < x){
                cur_l.next = cur;
                cur_l = cur;
            }else {
                cur_b.next = cur;
                cur_b = cur;
            }
            cur = cur.next;
        }

        cur_l.next = big.next;
        cur_b.next = null;

        return little.next;
    }
}
// @lc code=end

