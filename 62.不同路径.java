import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int path_num[] = new int[m+1];
        Arrays.fill(path_num, 1);
        path_num[0]=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<=m;j++){
                path_num[j] = path_num[j-1]+path_num[j];
            }
        }
        return path_num[m];
    }
}
// @lc code=end

