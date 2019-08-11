// import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        HashMap<Integer,Integer> m = new HashMap<>();
        int length = nums.length;
        for(int i=0;i<length;i++)
        {
            int a = nums[i];
            if(m.containsKey(target-a))
            {
                // result =  new int[]{i,m.get((target-a))};
                result[0] = i;
                result[1] = m.get((target-a));
            }
            m.put(nums[i], i);   
        }
        return result;
    }
}

