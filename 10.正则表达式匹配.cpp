/*
 * @lc app=leetcode.cn id=10 lang=cpp
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
public:
    bool isMatch(string s, string p) {
        int s_length = s.size();
        int p_length = p.size();

        if(p_length<=0) return s_length<=0;

        if(p_length>1 && p[1]=='*'){
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
};
// @lc code=end

