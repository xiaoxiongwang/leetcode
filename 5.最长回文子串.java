/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */
class Solution {
    public String add_length(String s)
    {
        String regex = "(.{1})";
        String new_s = s.replaceAll(regex, "$1#");
        return "#"+new_s;

    }
    public String longestPalindrome(String s) {
        String new_s = add_length(s);
        int length = new_s.length();
        int len[] = new int[length];
        len[0]=1;
        int rop=0;
        int mid=0;
        for(int i=0;i<length;i++)
        {
            if(i>rop)
            {
                len[i] = 1;
            }else{
                len[i] = Math.min(rop-i+1, len[2*mid-i]);
                // len[i] = rop-i>len[mid]?len[mid]:rop-i;
            }
            while(((i-len[i])>=0)&&(i+len[i]<length))
            {
                char x1 = new_s.charAt(i+len[i]),x2 = new_s.charAt(i-len[i]);
                if(x1==x2)
                {
                    len[i]++;
                }else{
                    break;
                }
            }
            if(len[i]>len[mid])
            {
                mid = i;
                rop = mid + len[i]-1;
            }

        }
        return new_s.substring(mid*2-rop,rop+1).replace("#", "");
    }
}