/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null,pre=null;
        int i = 0;
        int j = 0;
        while(l1!=null||l2!=null)
        {
            int tmp = 0;
            if(l1!=null)
            {
                tmp += l1.val;
                l1 = l1.next;
            }
            if(l2!=null)
            {
                tmp += l2.val;
                l2 = l2.next;
            }
            tmp += j;
            j = 0;
            if(tmp>9)
            {
                j = 1;
                tmp = tmp%10;
            }

            if(i==0)
            {
                head = new ListNode(tmp);
                head.next = null;
                pre = head;
            }else{
                ListNode cur = new ListNode(tmp);
                cur.next = null;
                pre.next = cur;
                pre = cur;
            }

            i++;
        }   
        if(j==1)
        {
            pre.next = new ListNode(1);
        }
        return head;
    }
}

