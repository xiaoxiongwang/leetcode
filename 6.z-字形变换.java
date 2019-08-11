import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */
class Solution {
    public String convert(String s, int numRows) {
        int num_row = 0;
        int length = s.length();
        if(numRows==1)
            return s;
        
        String sa[] = new String[numRows];
        Arrays.fill(sa, "");
        int flag = 1;
        for(int i=0;i<length;i++)
        {
            sa[num_row] = sa[num_row]+s.charAt(i);
            num_row += flag;
            if(num_row==numRows-1)
                flag = -1;
            if(i!=0&&num_row==0)
                flag = 1;
        }
        String result = "";
        for(int i=0;i<numRows;i++)
            result += sa[i];
        return result;
    }
}

