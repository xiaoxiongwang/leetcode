import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
 */
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
//  }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // if(lists.length==0) return null;
        ListNode dummy = new ListNode(0);

        PriorityQueue pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                // TODO Auto-generated method stub
                return o1.val-o2.val;
            }
        });

        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            ListNode temp = (ListNode)pq.poll();
            // System.out.println(temp.val);
            p.next = temp;
            p = p.next;
            if(p.next!=null)
                pq.add(p.next);
        }
        return dummy.next;
    }
}
// @lc code=end

