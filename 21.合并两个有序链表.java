/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode cur1=l1,cur2=l2,pre=null;

        if(cur1.val > cur2.val) return mergeTwoLists(l2, l1);
        
        while(cur1!=null || cur2!=null){
            if(cur1==null){
                pre.next = cur2;
                break;
            }
            if(cur2==null){
                break;
            }
            if(cur2.val < cur1.val){
                ListNode temp = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                cur1 = cur2;
                cur2 = temp;
            }else{
                pre = cur1;
                cur1 = cur1.next;
            }
        }
        return l1;
    }
}
// @lc code=end

