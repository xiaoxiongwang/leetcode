import java.util.List;

/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode p1 = head,p2=head.next,pre=null;
        if(p2==null) return head;
        ListNode newhead = p2;
        ListNode p3 = p2.next;

        while (true){
            if(pre!=null) pre.next = p2;
            pre = p1;
            p2.next = p1;
            p1.next = p3;
            p1=p3;
            if(p1==null){
                break;
            }
            p2=p1.next;
            // System.out.println(p1==null);
            if(p2==null){
                break;
            }
            p3=p2.next;
            
            // System.out.println(p2.val);
            // System.out.println(p3.val);
        } 
        return newhead;

    }
}
// @lc code=end

