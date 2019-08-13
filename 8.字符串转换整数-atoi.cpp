/*
 * @lc app=leetcode.cn id=8 lang=cpp
 *
 * [8] 字符串转换整数 (atoi)
 */
class Solution {
public:
    int myAtoi(string str) {
        int sign=1;
        int length=str.size();

        int i=0;
        int base=0;

        while(str[i]==' ') i++;

        if(str[i]=='+') sign=1;
        else if(str[i]=='-') sign=-1;
        else if(str[i]>='0'&&str[i]<='9') base=str[i]-'0';
        else return 0;
        i++;
        while(str[i]>='0'&&str[i]<='9')
        {
            if(base>INT_MAX/10||(base==INT_MAX/10&&(str[i]-'0'>=8)))
            {
                if(sign==1) return INT_MAX;
                if(sign==-1) return INT_MIN;
            }else
            {
                base = base*10 + (str[i]-'0');
            }
            
            i++;
        }
        
        return base*sign;

    }
};

