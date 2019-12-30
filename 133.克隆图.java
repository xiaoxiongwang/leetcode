import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        HashMap<Node,Node> visit = new HashMap<>();
        Node head = new Node(node.val,new LinkedList<Node>());
        queue.add(node);
        visit.put(node, head);

        while(!queue.isEmpty()){
            Node cur = queue.pop();
            
            List<Node> neighbors = cur.neighbors;
            for(Iterator<Node> it = neighbors.iterator();it.hasNext();){
                Node neighbor = it.next();
                if(!visit.containsKey(neighbor)){
                    Node temp = new Node(neighbor.val,new LinkedList<Node>());
                    visit.put(neighbor, temp);
                    queue.add(neighbor);
                }
                visit.get(cur).neighbors.add(visit.get(neighbor));
            }
        }
        return head;
    }
}
// @lc code=end

