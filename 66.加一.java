/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len-1;
        int flag = 0;
        while(i>=0){
            int temp = digits[i]+flag;
            if(i==len-1) temp++;
            if(temp>9){
                flag=1;
                digits[i] = temp%10;
            }else{
                flag=0;
                digits[i] = temp;
            }
            i--;
        }
        // System.out.println("-------------");
        if(flag==1){
            int result[] = new int[len+1];
            for(int j=1;j<=len;j++){
                result[j]=digits[j-1];
            }
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
// @lc code=end

