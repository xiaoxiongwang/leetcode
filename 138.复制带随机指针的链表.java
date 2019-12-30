import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        // if (head == null) return null;
        // HashMap<Node,Node> map = new HashMap<Node,Node>();

        // Node new_head = new Node(head.val);
        // map.put(head, new_head);
        // Node p = head.next, q = new_head;
        // while(p!=null){
        //     Node temp = new Node(p.val);
        //     map.put(p, temp);
        //     q.next = temp;
        //     q = temp;
        //     p = p.next;
        // }
        // p = head;
        // q = new_head;
        // while(p!=null){
        //     q.random = map.get(p.random);
        //     p=p.next;
        //     q=q.next;
        // }
        // return new_head;

        if(head==null) return null;

        Node p = head;
        while(p!=null){
            Node temp = p.next;
            Node newnode = new Node(p.val);
            p.next = newnode;
            newnode.next = temp;
            p = temp;
        }
        p=head;

        while(p!=null){
            Node pnext = p.next;
            pnext.random = (p.random==null)?null:(p.random.next);
            p = pnext.next;
        }

        Node dummy = new Node(0);
        p=head;

        Node q = dummy;
        while(p!=null){
            Node pnext = p.next;
            q.next = pnext;
            q = pnext;
            p.next = pnext.next;
            p = pnext.next;
        }
        return dummy.next;

    }
}
// @lc code=end

