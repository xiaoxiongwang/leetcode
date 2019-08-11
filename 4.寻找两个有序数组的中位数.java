/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        if(length1>length2)
            return findMedianSortedArrays(nums2, nums1);  

        int low = 0;
        int high = length1*2;
        int l1=0,r1=0,l2=0,r2=0;
        while(low <= high)
        {
            int c1 = (high+low)/2;
            int c2 = length - c1;

            if(c1==0)
            {
                l1 = Integer.MIN_VALUE;
            }else{
                l1 = nums1[(c1-1)/2]; 
            }

            if(c2==0)
            {
                l2 = Integer.MIN_VALUE;
            }else{
                l2 = nums2[(c2-1)/2]; 
            }

            if(c1==2*length1)
            {
                r1 = Integer.MAX_VALUE;
            }else{
                r1 = nums1[c1/2];
            }

            if(c2==2*length2)
            {
                r2 = Integer.MAX_VALUE;
            }else{
                r2 = nums2[(c2)/2]; 
            }

            if(l1>r2)
            {
                high = c1-1;
            }else if(l2>r1){
                low = c1+1;
            }else{
                break;
            }
        }
        return (Math.max(l1, l2)+Math.min(r1,r2))/2.0;
    }
}

