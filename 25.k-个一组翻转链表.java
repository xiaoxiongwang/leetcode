import java.util.List;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return head;
        ListNode pre = null;
        ListNode start = head;
        ListNode end=null,tail=null;

        while(true){
            ListNode p = start;
            // System.out.println(p.val);
            ListNode pnext = p.next;
            if(pnext==null) break;
            boolean flag = false;
            int i=1;
            for(;i<k;i++){
                if(pnext==null){
                    // System.out.println("come in ");
                    flag = true;
                    break;
                }
                
                ListNode pnextnext = pnext.next;

                pnext.next = p;

                p = pnext;
                pnext = pnextnext;
                // System.out.println(p.val);
                // System.out.println(pnextnext.val);
            }
            if(flag){
                ListNode cur = p,pre2=p.next;
                cur.next=null;
                for(int j=1;j<i;j++){
                    ListNode temp = pre2.next;
                    pre2.next = cur;
                    cur = pre2;
                    pre2 = temp;
                }
                break;
                // end = p;
                // tail = null;
            }else{
                // System.out.println("test");
                end = p;
                tail=pnext;
            }
            if(pre==null){
                head = end;
                // System.out.println(head.val);
            }else{
                pre.next = end;
            }
            start.next = tail;
            pre=start;
            start=tail;

            if(start==null) break;

        }
        return head;
    }
}
// @lc code=end

