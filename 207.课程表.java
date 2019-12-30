import java.util.Arrays;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        return num == numCourses;
    }
}
// @lc code=end

