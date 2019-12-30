import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(nums.length<3) return list;

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
            // System.out.println(flag);
        }
        int pre_m=nums[0]+1;
        int pre_n=nums[1]+1;
        for(int m=0;m<nums.length;m++){
            if(pre_m==nums[m]) continue;
            for(int n=m+1;n<nums.length;n++){
                if(pre_n==nums[n]) continue;
                List<Integer> tmp = new LinkedList<Integer>();
                int x = -(nums[m]+nums[n]);
                if(map.containsKey(x)){
                    if(map.get(x)>n){
                        tmp.add(nums[m]);
                        tmp.add(nums[n]);
                        tmp.add(nums[map.get(x)]);
                        list.add(tmp);
                    }
                }
                pre_n = nums[n];
            }
            pre_m = nums[m];
        }
        return list;
    }
}
// @lc code=end

