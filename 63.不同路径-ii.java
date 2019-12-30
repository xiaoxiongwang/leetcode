import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int one_length = obstacleGrid.length;
        int two_length = obstacleGrid[0].length;

        int path_num[] = new int[two_length+1];
        Arrays.fill(path_num, 0);
        for(int i=1;i<=one_length;i++){
            for(int j=1;j<=two_length;j++){
                if(i==1&&j==1){
                    if(obstacleGrid[0][0]==0){
                        path_num[1]=1;
                        continue;
                    }else{
                        return 0;
                    }
                }
                if(obstacleGrid[i-1][j-1]==1) path_num[j]=0;
                else    path_num[j]=path_num[j]+path_num[j-1];
            }
            // for(int m=0;m<=two_length;m++){
                // System.out.print(path_num[m]+" ");
            // }
            // System.out.println();
        }
        
        return path_num[two_length];
    }
}
// @lc code=end

