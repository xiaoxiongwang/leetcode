import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start
class Solution {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int edge_length = edges.length;
        if(edge_length==0) {
            LinkedList<Integer> r = new LinkedList<Integer>();
            r.add(0);
            return r;
        }
        // int out[] = new int[n];
        // int in[] = new int[n];
        List<Integer> result = new LinkedList<Integer>();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        HashMap<Integer,List<Integer>> E = new HashMap<>();
        for(int i=0;i<n;i++){
            E.put(i, new LinkedList<Integer>());
        }

        // Arrays.fill(out, 0);
        for(int i=0;i<edge_length;i++){
            E.get(edges[i][0]).add(edges[i][1]);
            E.get(edges[i][1]).add(edges[i][0]);
        }
        int total = n;
        for(int i=0;i<n;i++){
            if(E.get(i).size()==1){
                tmp.add(i);
            }
        }
        while(total>2){
            total = total - tmp.size();
            LinkedList<Integer> new_temp = new LinkedList<Integer>();
            while(!tmp.isEmpty()) {
                int i = tmp.pop();
                if(E.get(i).size()==1){
                    int cur=E.get(i).remove(0);
                    E.get(cur).removeIf(s->s.intValue()==i);
                    if(E.get(cur).size()==1) new_temp.add(cur);
                }
            }
            tmp = new_temp;
        }
        return tmp;
    }
}
// @lc code=end

