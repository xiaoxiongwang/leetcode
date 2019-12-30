import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;
/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */
// class Solution {
    
// }


class Test{
    public static boolean isMatch(String s, String p) {
        int p_length = p.length();
        int s_length = s.length();
        System.out.println(p);
        System.out.println(s);
        System.out.println(".....................");

        if(p_length<=0) return s_length<=0;

        if(p_length>1 && p.charAt(1)=='*'){
            if(s_length<=0) return isMatch("", p.substring(2, p_length));
            return isMatch(s, p.substring(2,p_length))||((s.charAt(0)==p.charAt(0)||
                p.charAt(0)=='.') && isMatch(s.substring(1, s_length), p));
        }else if(p.charAt(0)=='.'){
            if(s_length<=0) return false;
            return isMatch(s.substring(1, s_length), p.substring(1, p_length));
        }else{
            if(s_length<=0) return false;
            return isMatch(s.substring(1, s_length), p.substring(1, p_length))&&s.charAt(0)==p.charAt(0);
        }

        // if(s.charAt(0)==p.charAt(0)) return isMatch(s.substring(1,s_length), p.substring(1,p_length));


        // return true;
    }
    public static void printbooleanarray(boolean d[][]){
        for (boolean[] bs : d) {
            for (boolean bs2 : bs) {
                System.out.print(bs2+" ");
            }
            System.out.println();
        }
    }
    public static boolean isMatch2(String s, String p) {
        int s_length = s.length();
        int p_length = p.length();
        boolean d[][] = new boolean[s_length+1][p_length+1];
        d[0][0] = true;
        for(int i=1;i<s_length;i++){
            d[i][0]=false;
        }
        for(int j=1;j<=p_length;j++){
            d[0][j]= (j > 1) && d[0][j-2] && p.charAt(j-1)=='*';
        }
        printbooleanarray(d);

        for(int m=1;m<=p_length;m++){
            for(int n=1;n<s_length;n++){
                if(p.charAt(m-1)=='*'){
                    System.out.println(n);
                    System.out.println(m);
                    // System.out.println();
                    d[n][m] = (s.charAt(n-1)==p.charAt(m-2)||p.charAt(m-2)=='.')?d[n-1][m-1]:d[n][m-2];
                }else{
                    d[n][m] = (s.charAt(n-1)==p.charAt(m-1)||p.charAt(m-1)=='.')?d[n-1][m-1]:false;
                }
            }
        }
        printbooleanarray(d);
        return d[s_length][p_length];
    }
    public static int maxArea(int[] height) {
        int length = height.length;
        int max_contain = -1;
        int i=0,j=length-1;
        while(i<j){
            int area = Math.min(height[i], height[j])*(j-i);
            if(area>max_contain){
                System.out.println(i);
                System.out.println(j);
                System.out.println("------------");
                max_contain = area;
            }
            if(height[i]>=height[j]) j--;
            else if(height[i]<height[j]) i++;
        }
        return max_contain;
    }
        public static int maxArea2(int[] height) {
        int length = height.length;
        int max_contain = -1;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                    int contain = (height[i]>height[j]?height[j]:height[i])*(j-i);
                    if(contain>max_contain){
                        System.out.println(i);
                        System.out.println(j);
                        max_contain = contain;
                    }
            }
        }
        return max_contain;
    }
    public static String intToRoman(int num) {
        Map<Integer,String> map = new TreeMap<Integer,String>(){
            {
                put(1, "I");
                put(5, "V");
                put(10,"X");
                put(50, "L");
                put(100, "C");
                put(500,"D");
                put(1000, "M");
            }
        };
        // System.out.println(map.keySet());
        // Set<Integer> base = map.keySet();
        // System.out.println(base);
        int bases[] = {1000,500,100,50,10,5,1};
        String result = "";
        for (int j=0;j<bases.length;j++) {
            int i = bases[j];
            
            int n = (num-num % i)/i;
            if(n==0) continue;
            if(n==4 ){
                result = map.get(i) + map.get(bases[j-1]);
            }else if(n==9){
                result = map.get(bases[j+1]) + map.get(bases[j-1]);
                num = num - (bases[j-1]-bases[j+1]);
                continue;
            }else{
                for(int k=0;k<n;k++){
                    result = result + map.get(i);
                }
            }
            

            num = num-n*i;
            if(num==0) break;
        }


        return result;
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int result[] = new int[numCourses];
        int index = 0;
        int prerequisites_length = prerequisites.length;
        int out[] = new int[numCourses];
        int num = 0;
        Arrays.fill(out, 0);
        for(int i=0;i<prerequisites_length;i++){
            out[prerequisites[i][0]]++;
        }
        LinkedList<Integer> link = new LinkedList<>();
        for(int j=0;j<numCourses;j++){
            if(out[j]==0) {
                link.add(j);
                num++;
            };
        }

        while(!link.isEmpty()){
            int cur = link.pop();
            result[index++] = cur;
            for(int i=0;i<prerequisites_length;i++){
                if(prerequisites[i][1]==cur){
                    out[(prerequisites[i][0])]--;
                    if(out[(prerequisites[i][0])]==0) {
                        link.add(prerequisites[i][0]);
                        num++;
                    }
                }
            }
        }
        if(num == numCourses){
            return result;
        }else{
            return new int[0];
        }
    }
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int edge_length = edges.length;
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
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = middle(1, n);
        return result;
    }
    public static List<TreeNode> middle(int start,int end){
        List<TreeNode> result = new LinkedList<TreeNode>();
        if(start>end) {
            result.add(null);
            return result;
        }
        for(int i=start;i<=end;i++){
            TreeNode cur = new TreeNode(i);
            List<TreeNode> leftnodes = middle(start, i-1);
            List<TreeNode> rightnodes = middle(i+1, end);
            if(i==1){
                System.out.println("left: "+Integer.toString(start) +" "+Integer.toString(i-1));
            for (TreeNode treeNode : leftnodes) {
                if(treeNode==null) System.out.println("null");
                else
                System.out.print(treeNode.val+" ");
            }
            System.out.println();
            System.out.println("right: "+Integer.toString(i+1) +" "+Integer.toString(end));
            for (TreeNode treeNode : rightnodes) {
                if(treeNode==null) System.out.println("null");
                else
                System.out.print(treeNode.val+" ");
            }
            System.out.println();
            }
            
            // boolean flag = true;
            for (TreeNode leftnode : leftnodes) {
                for (TreeNode rightnode : rightnodes) {
                    // flag = false;
                    cur.left = leftnode;
                    cur.right = rightnode;
                    result.add(cur);
                }
            }
            
        }
        return result;
    }
    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2=new Student(2);
        Student s3=new Student(3);
        // Comparator<Student> comparator = new Comparator<Student>() {
        //     @Override
        //     public int compare(Student o1, Student o2) {
        //         return (o2.id - o1.id);
        //     }
        // };
        PriorityQueue pq = new PriorityQueue<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o2.id - o1.id);
            }
        });
        pq.add(s2);
        pq.add(s1);
        pq.add(s3);
        
        System.out.println(pq.peek());
        System.out.println(pq.peek());
        System.out.println(pq.peek());
        // String s = "09";
        // System.out.println(Integer.parseInt(s));
        // String s = "test";
        // System.out.println(s.substring(4,4).length());
        // LinkedList test = new LinkedList();
        // test.push(3);
        // test.push(4);
        // System.out.println(test);
        // System.out.println(null==null);
        // System.out.println(generateTrees(3));
        // int edges[][] = {{1,0},{1,2},{1,3}};
        // System.out.println(findMinHeightTrees(4, edges));
    // }
    // public static void main(String[] args) {
        // int num=2;
        // int a[][] = new int[1][2];
        // a[0][0]=1;
        // a[0][1]=0;
        // System.out.println(findOrder(num, a)[0]);
        // System.out.println(findOrder(num, a)[1]);
        // HashMap<Integer,List<Integer>> E = new HashMap<>();
        // E.put(1, new LinkedList<>());
        // System.out.println(E.get(1).isEmpty());
        // LinkedList<Integer> test = new LinkedList<Integer>();
        // test.add(3);
        // test.add(4);
        // test.clear();
        // System.out.println(test.remove(0));
        // System.out.println(new int[0]);
        // LinkedList test = new LinkedList<>();
        // test.add(3);
        // test.add(4);
        // System.out.println(test.pop());
        // HashMap m = new HashMap<>();
        // System.out.println(intToRoman(1994));
        // int x[] = {4,4,2,11,0,11,5,11,13,8};
        // System.out.println(maxArea(x));
        // System.out.println(isMatch2("aaa", "ab*a*c*a"));
        // String s = "wang";
        // System.out.println(s.substring(4));
    }
}
class Student{
    int id;
    public Student(int id){
        this.id=id;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return id+"";
    }
}