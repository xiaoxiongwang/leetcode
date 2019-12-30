/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    // public int maxArea(int[] height) {
    //     int length = height.length;
    //     int max_contain = -1;
    //     for(int i=0;i<length;i++){
    //         for(int j=i+1;j<length;j++){
    //                 int contain = (height[i]>height[j]?height[j]:height[i])*(j-i);
    //                 if(contain>max_contain){
    //                     max_contain = contain;
    //                 }
    //         }
    //     }
    //     return max_contain;
    // }
    // tow pointer
    public int maxArea(int[] height) {
        int length = height.length;
        int max_contain = -1;
        int i=0,j=length-1;
        while(i<j){
            int area = Math.min(height[i], height[j])*(j-i);
            if(area>max_contain){
                max_contain = area;
            }
            if(height[i]>=height[j]) j--;
            else i++;
        }
        return max_contain;
    }
}
// @lc code=end

