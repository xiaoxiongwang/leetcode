/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;

        if(len==0) return "";
       
        int min_length = strs[0].length();

        for(int k=1;k<len;k++){
            min_length = Math.min(min_length, strs[k].length());
        }

        boolean flag = true;
        int i=0;
        for(;i<min_length&&flag;i++){
            char tmp = strs[0].charAt(i);
            for(int j=1;j<len;j++){

                if(strs[j].charAt(i)!=tmp){
                    flag = false;
                    break;
                }
            }

        }
        if(!flag) i--;

        return strs[0].substring(0,i);
        
    }

}
// @lc code=end

