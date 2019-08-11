/*
 * @lc app=leetcode.cn id=4 lang=cpp
 *
 * [4] 寻找两个有序数组的中位数
 */
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int length1 = nums1.size();
        int length2 = nums2.size();
        int length = length1 + length2;

        if(length1>length2)
            return findMedianSortedArrays(nums2,nums1);

        int l1=0,r1=0,l2=0,r2=0;
        int low = 0;
        int high = 2*length1;

        while(low<=high)
        {
            int c1 = (low+high)/2;
            int c2 = length-c1;

            if(c1==0)
            {
                l1 = INT_MIN;
            }
            else
            {
                l1 = nums1[(c1-1)/2];
            }
            
            if(c1==length1*2)
            {
                r1 = INT_MAX;
            }
            else
            {
                r1 = nums1[c1/2];
            }
            
            if(c2==0)
            {
                l2 = INT_MIN;
            }
            else
            {
                l2 = nums2[(c2-1)/2];
            }
            
            if(c2==length2*2)
            {
                r2 = INT_MAX;
            }
            else
            {
                r2 = nums2[c2/2];
            }

            if(l1>r2)
            {
                high = c1 -1;
            }else if(l2>r1){
                low = c1 +1;
            }else{
                break;
            }
        }
        return (std::max(l1,l2)+std::min(r1,r2))/2.0;
        
    }
};

