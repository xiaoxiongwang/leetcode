/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int length = nums.size();
        unordered_map<int,int> m;
        vector<int> result;
        for(int i=0;i<length;i++)
        {
            int a = nums[i];
            if(m.find(target-a)!=m.end())
            {
                result.push_back(i);
                result.push_back(m[target-a]);
            }
            m[a] = i;
        }
        return result;
    }
};

