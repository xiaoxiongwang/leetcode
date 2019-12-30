/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        int len = 0;
        ListNode cur = head,pre=null;
        while(cur!=null){
            len++;
            pre = cur;
            cur = cur.next;
        }
        pre.next = head;

        int step = len - k%len;
        cur = head;
        int h=0;
        while(h<step-1){
            h++;
            cur = cur.next;
        }
        ListNode result = cur.next;

        cur.next=null;

        return result;

    }
}
// @lc code=end

