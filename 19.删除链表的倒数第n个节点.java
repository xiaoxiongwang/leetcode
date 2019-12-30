import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        LinkedList<ListNode> stack = new LinkedList<ListNode>();

        ListNode cur = head;
        while(cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        int i=0;
        while(i<n){
            cur = stack.pop(); 
            i++;
        }
        if(stack.isEmpty()){
            return head.next;
        }else{
            cur = stack.pop();
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = null;
        }
        

        return head;
    }
}
// @lc code=end

