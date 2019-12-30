/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null||m==n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        int i=0;
        ListNode cur = head,pre=null,start=null,end=null,tail=null,preNode =null;
        boolean flag = true;
        while(cur!=null){
            if(i==m-1){
                pre = cur;
                start = pre.next;
            }else if(i==m){
                preNode=cur;
            }else if(i>m&&i<=n){
                if(i==n){
                    // System.out.println("come in "+cur.val);
                    end = cur;
                }
                ListNode temp = cur.next;
                cur.next = preNode;
                preNode = cur;
                cur = temp;
                i++;
                continue;
            }else if(i==n+1){
                flag = false;
                tail = cur;
                pre.next = end;
                start.next = tail;
            }
            cur = cur.next;
            i++;
            // System.out.println(i);
        }
        if(flag){
            tail = cur;
            // System.out.println(pre.val);
            // System.out.println(end.val);
            // System.out.println(start.val);
            pre.next = end;
            start.next = tail;
        }

        ListNode prin = dummy;
        // while(prin!=null){
        //     System.out.println(prin.val);
        //     prin=prin.next;
        // }
        return dummy.next;
    }
}
// @lc code=end

