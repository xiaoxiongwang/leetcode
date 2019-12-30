/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int w1_length = word1.length(),w2_length=word2.length();
        int d[][] = new int[w1_length+1][w2_length+1];

        for(int i=0;i<=w1_length;i++){
            d[i][0]=i;
        }
        for(int j=0;j<=w2_length;j++){
            d[0][j]=j;
        }
        // for(int i=0;i<=w1_length;i++)
        //     for(int j=0;j<=w2_length;j++)
        //         System.out.println(d[i][j]);

        for(int i=1;i<=w1_length;i++){
            for(int j=1;j<=w2_length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    d[i][j]=d[i-1][j-1];
                }else{
                    d[i][j]=Math.min(Math.min(d[i-1][j-1],d[i-1][j]),d[i][j-1])+1;                                                                                                  
                }
            }
        }
        return d[w1_length][w2_length];
    }
}
// @lc code=end

