
/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */
class Solution {
    // public boolean isMatch(String s, String p) {
    //     int p_length = p.length();
    //     int s_length = s.length();

    //     if(p_length<=0) return s_length<=0;

    //     if(p_length>1 && p.charAt(1)=='*'){
    //         if(s_length<=0) return isMatch("", p.substring(2, p_length));
    //         return isMatch(s, p.substring(2,p_length))||((s.charAt(0)==p.charAt(0)||p.charAt(0)=='.') && isMatch(s.substring(1, s_length), p));
    //     }else if(p.charAt(0)=='.'){
    //         if(s_length<=0) return false;
    //         return isMatch(s.substring(1, s_length), p.substring(1, p_length));
    //     }else{
    //         if(s_length<=0) return false;
    //         return isMatch(s.substring(1, s_length), p.substring(1, p_length))&&s.charAt(0)==p.charAt(0);
    //     }

    //     // if(s.charAt(0)==p.charAt(0)) return isMatch(s.substring(1,s_length), p.substring(1,p_length));


    //     // return true;
    // }
    public boolean isMatch(String s, String p) {
        int s_length = s.length();
        int p_length = p.length();
        boolean d[][] = new boolean[s_length+1][p_length+1];
        d[0][0] = true;
        for(int i=1;i<s_length;i++){
            d[i][0]=false;
        }
        for(int j=1;j<=p_length;j++){
            d[0][j]= (j > 1) && d[0][j-2] && p.charAt(j-1)=='*';
        }
        for(int m=1;m<=p_length;m++){
            for(int n=1;n<=s_length;n++){
                if(p.charAt(m-1)=='*'){
                    if(d[n][m-2]){
                        d[n][m]=true;
                    }else{
                        d[n][m] = (s.charAt(n-1)==p.charAt(m-2)||p.charAt(m-2)=='.')?d[n-1][m]:false;
                    }
                }else{
                    d[n][m] = (s.charAt(n-1)==p.charAt(m-1)||p.charAt(m-1)=='.')?d[n-1][m-1]:false;
                }
            }
        }
        return d[s_length][p_length];
    }
}

