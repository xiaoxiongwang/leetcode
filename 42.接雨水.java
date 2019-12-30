/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if(height.length==0) return 0;
        int maxleft[] = new int[height.length];
        int maxright[] = new int[height.length];
        maxleft[0] = height[0];
        maxright[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++){
            maxleft[i] = Math.max(maxleft[i-1], height[i]);
        }

        for(int j=height.length-2;j>=0;j--){
            maxright[j] = Math.max(maxright[j+1], height[j]);
        }

        int ans = 0;
        for(int m=0;m<height.length;m++){
            // System.out.println("-------------------");
            // System.out.println(m);
            // System.out.println(maxleft[m]);
            // System.out.println(maxright[m]);
            // System.out.println(height[m]);
            // System.out.println(Math.min(maxleft[m], maxright[m])-height[m]);
            ans += Math.min(maxleft[m], maxright[m])-height[m];

        }
        return ans;
    }
}
// @lc code=end

