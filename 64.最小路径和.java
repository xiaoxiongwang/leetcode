import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int one_length = grid.length;
        int two_length = grid[0].length;
        
        int path_min[] = new int[two_length+1];
        Arrays.fill(path_min, Integer.MAX_VALUE);
        path_min[0]=0;
        for(int i=1;i<=one_length;i++){
            // path_min
            if(i!=1) path_min[0]=Integer.MAX_VALUE;
            for(int j=1;j<=two_length;j++){
                path_min[j]=grid[i-1][j-1]+Math.min(path_min[j], path_min[j-1]);
            }
        }
        return path_min[two_length];
    }
}
// @lc code=end

