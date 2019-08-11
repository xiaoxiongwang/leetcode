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
        string result =  new_s.substr(2*mid-rop,(rop-mid)*2+1);
        // std::cerr << result << std::endl;
        // result.erase(std::remove(result.begin(), result.end(), '#'), result.end());
        result = delete_s(result);
        return result;
        // return new_s;
    }
};
