/*
 * @lc app=leetcode.cn id=6 lang=cpp
 *
 * [6] Z 字形变换
 */
class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows==1)
            return s;
        string sa[numRows];
        fill_n(sa,numRows,"");

        int length = s.size();
        int flag = 1;
        int num_row=0;
        for(int i=0;i<length;i++)
        {
            sa[num_row] = sa[num_row] + s[i];
            num_row = num_row +flag;
            if(num_row == numRows-1)
            {
                flag = -1;
            }
            if(num_row==0){
                flag = 1;
            }
        }

        string result="";
        for(int i=0;i<numRows;i++)
            result = result+sa[i];

        return result;
    }
};

