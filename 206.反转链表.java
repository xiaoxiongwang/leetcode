/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    //非递归解法
    // public ListNode reverseList(ListNode head) {
    //     ListNode dummy = new ListNode(0);

    //     ListNode cur = head;
    //     while(cur!=null){
    //         ListNode temp = cur.next;
    //         cur.next = dummy.next;
    //         dummy.next = cur;
    //         // dummy_cur = cur;
    //         cur = temp;
    //     }
    //     return dummy.next;
    // }
    //递归解法
    public ListNode reverseList(ListNode head) {
        if(head.next!=null && head.next.next==null){
            
        }
    }
}
// @lc code=end

