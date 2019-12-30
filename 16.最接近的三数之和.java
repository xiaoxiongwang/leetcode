import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int num_length = nums.length;
        if(num_length<3) return 0;
        // if(num_length==1) return nums[0];
        int sum = nums[0]+nums[1]+nums[2];
        for(int i=0;i<num_length;i++){
            int start = i+1, end = num_length-1;

            while(start<end){
                int temp = nums[i]+nums[start]+nums[end];
                // System.out.println(temp);
                // System.out.println(Math.abs(temp-target));
                // System.out.println(Math.abs(sum-target));
                // System.out.println("-------------------");
                if(Math.abs(temp-target)<Math.abs(sum-target)){
                    sum = temp;
                    // System.out.println("sum:"+sum);
                }
                if(temp<target){
                    start++;
                }else if(temp>target){
                    end--;
                }else{
                    return target;
                }

            }
        }
        // System.out.println("final sum:"+sum);
        return sum;
    }
}
// @lc code=end

