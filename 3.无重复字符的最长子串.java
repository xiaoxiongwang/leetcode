import java.util.Arrays;

import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start =0 ;
        int max_length = 1;
        int length = s.length();
        if(length==0) return 0;

        int map_char[] = new int[205];
        Arrays.fill(map_char, -1);
        map_char[(int)(s.charAt(0))]=0;
        // for(int i=0;i<129;i++)
        // {
        //     map_char[i] = -1;
        // }
        for(int j=1;j<length;j++)
        {
            int temp = (int)(s.charAt(j));
            if(map_char[temp]==-1)
            {
                map_char[temp] = j;
            }else if(map_char[temp]<start){
                map_char[temp]= j;
            }else{
                if(j-start>max_length) max_length = j- start;
                start = map_char[temp]+1;
                map_char[temp] = j;
                continue;
            }
            if(j+1-start>max_length)
                max_length = j+1-start;
        }

        return max_length;
    }
}

