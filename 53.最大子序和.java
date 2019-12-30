import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int nums_length = nums.length;
        // int length[] = new int[nums_length];
        // Arrays.fill(length, Integer.MIN_VALUE);
        int sum = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums_length;i++){
            if(sum>0){
                sum = nums[i]+sum;
            }else{
                sum = nums[i];
            }
            if(sum>max) max = sum;
            // System.out.println(sum);
        }
        return max;

    }
}
// @lc code=end

