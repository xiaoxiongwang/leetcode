#include<iostream>
#include<vector>
#include<unordered_map>
#include<limits.h>
#include<string>
using namespace std;

/*
 * @lc app=leetcode.cn id=5 lang=cpp
 *
 * [5] 最长回文子串
 */
class Solution {
public:
    string add(string s)
    {
        // std::cerr << s << std::endl;
        int length = s.size();
        string new_s("#");
        for(int i=0;i<length;i++)
        {
            new_s = new_s + s[i]+"#";
            // std::cerr << new_s << std::endl;
        }
        // std::cerr << new_s << std::endl;
        return new_s;
    }
    string delete_s(string s)
    {
        int length = s.size();
        string new_s("");
        for(int i=0;i<length;i++)
        {
            if(i%2!=0)
                new_s = new_s + s[i];
            // std::cerr << new_s << std::endl;
        }
        return new_s;
    }
    // string delete(string s)
    // {
    //     int length = s.size();
    //     string new_s("");
    //     for(int i=0;i<length;i++)
    //     {
    //         if(s[i]!='#')
    //         {
    //             new_s = new_s + s[i];
    //         }
    //         std::cerr << new_s << std::endl;
    //     }
    //     std::cerr << new_s << std::endl;
    //     return new_s;
    // }
    string longestPalindrome(string s) {
        string new_s = add(s);
        // std::cerr << new_s << std::endl;
        int length = new_s.size();
        int rop=0,mid=0;
        int len[length];
        fill_n(len,length,0);
        len[0]=1;
        for(int i=0;i<length;i++)
        {
            // std::cout << "start" << i<< std::endl;
            if(i>rop)
            {
                len[i]=1;
            }else{
                len[i] = min(rop-i+1,len[2*mid-i]);
            }

            while(((i-len[i])>=0)&&((i+len[i])<length))
            {
                if(new_s[i-len[i]]==new_s[i+len[i]])
                {
                    len[i]++;
                }else
                {
                    break;
                }
                
            }
            if(len[i]>len[mid])
            {
                mid = i;
                rop = mid + len[i] -1;
            }
        }
        // std::cout << "over" << std::endl;
        // std::cerr << new_s << std::endl;
        string result =  new_s.substr(2*mid-rop,rop+1);
        // std::cerr << result << std::endl;
        // result.erase(std::remove(result.begin(), result.end(), '#'), result.end());
        result = delete_s(result);
        return result;
        // return new_s;
    }
};

bool isMatch(string s, string p) {
        int s_length = s.size();
        int p_length = p.size();

        if(p_length<=0) return s_length<=0;

        if(p_length>1 && p[1]=='*'){
            // std::cerr << p.substr(2,p_length).size() << std::endl;
            std::cerr << s.substr(1,s_length) << std::endl;
            if(s_length<=0) return isMatch("",p.substr(2,p_length));
            return isMatch(s,p.substr(2,p_length))||((s[0]==p[0]||p[0]=='.')&&isMatch(s.substr(1,s_length),p));
        }else if(p[0]=='.'){
            if(s_length<=0) return false;
            return isMatch(s.substr(1,s_length),p.substr(1,p_length));
        }else{
            if(s_length<=0) return false;
            return (s[0]==p[0])&&isMatch(s.substr(1,s_length),p.substr(1,p_length));
        }
}

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
            std::cerr << base << std::endl;
            if(base>INT_MAX/10||(base==INT_MAX/10&&(str[i]-'0'>=7)))
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
int isPalindrome(int x) {
        int z= x;
        if(x<0)
            return false;
        int length =0;
        while(x!=0){
            x/=10;
            length++;
        }
        int high = 1;
        for(int i=0;i<length-1;i++)
        {
            high *= 10;
        }
        int low = 10;
        int y =z;
        x = z;
        int count=0;
        while(true)
        // while((x/high==y%low)&&(count<length/2))
        {
            std::cerr << x << " "<<x/high << " "<<y << " "<<y%low<<std::endl;
            if(x/high!=y%low) return false;
            else if(count>=length/2) return true;
            else{
                count++;
                // high = high/10;
                // low = low*10;
                y = y/10;
                x = x-x/high;
                high = high/10;
            }
            
        }
    }
int main()
{
    // string s = "p*";
    // std::cerr << s.substr(3,2) << std::endl;
    // int result = myAtoi("-2147483648");
    Solution *solution = new Solution;
    std::cerr << isMatch("aa","a*")<<std::endl;
    // string s = "ababc";
    // string result = solution->longestPalindrome(s);
    // std::cerr << solution->delete_s(s) << std::endl;
    // std::cerr << isPalindrome(121) << std::endl;
    // std::cout << "hello world" << std::endl;
    // vector<int> nums;
    // nums.push_back(1);
    // std::cerr << nums.size() << std::endl;
    // unordered_map<int,int> m;
    // m[3] = 5;
    // std::cerr << m[3] << std::endl;

    // string s("test");
    // s = s+"#";
    // std::cerr << s << std::endl;
}