import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


class TestGraph
{
    public static Node cloneGraph(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        HashMap<Node,Node> visit = new HashMap<>();
        Node head = new Node(node.val,new LinkedList<Node>());
        queue.add(node);
        visit.put(node, head);

        while(!queue.isEmpty()){
            Node cur = queue.pop();
            
            List<Node> neighbors = cur.neighbors;
            // System.out.println(neighbors);
            for(Iterator<Node> it = neighbors.iterator();it.hasNext();){
                Node neighbor = it.next();
                System.out.println(neighbor.val);
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
    public static void main(String[] args) {
        Node n1 = new Node(1,new LinkedList<>());
        Node n2 = new Node(2,new LinkedList<>());
        Node n3 = new Node(3,new LinkedList<>());
        Node n4 = new Node(4,new LinkedList<>());

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node head = cloneGraph(n1);
        // System.out.println(head.val);
        // System.out.println(head.neighbors);



    }
}