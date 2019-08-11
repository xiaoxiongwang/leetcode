/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] 无重复字符的最长子串
 */
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int start = 0;
        int length = s.size();
        if(length==0) return 0;
        int max_length = 1;
        int map_char[128];
        // for(int i=0;i<128;i++)
        // {
            // map_char[i] = -1;
        // }
        fill_n(map_char,128,-1);
        map_char[s[0]] = 0;
        for(int j=1;j<length;j++)
        {
            if(map_char[s[j]]==-1)
            {
                map_char[s[j]] = j;
                if(j-start+1>max_length)
                    max_length = j-start+1;
            }else if(map_char[s[j]]<start)
            {
                map_char[s[j]] = j;
                if(j-start+1>max_length)
                    max_length = j-start+1;
            }else
            {
                if(j-start>max_length)
                    max_length = j-start;
                start = map_char[s[j]]+1;
                map_char[s[j]] = j;
            }
        }
        return max_length;
    }
};

