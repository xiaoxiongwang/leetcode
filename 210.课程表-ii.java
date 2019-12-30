/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
}
// @lc code=end

