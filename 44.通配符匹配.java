/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int s_length = s.length();
        int p_length = p.length();

        boolean d[][] = new boolean[s_length+1][p_length+1];
        d[0][0] = true;
        
        for(int i=1;i<s_length;i++){
            d[i][0] = false;
        }

        boolean flag = true;
        for(int j=1;j<=p_length;j++){
            if(p.charAt(j-1)=='*' && flag){
                d[0][j]=true;
            }else{
                d[0][j]=false;
                flag = false;
            }
        }

        for(int m=1;m<=s_length;m++){
            char char_s = s.charAt(m-1);
            for(int n=1;n<=p_length;n++){
                char char_p = p.charAt(n-1);
                if(char_p=='*'){
                    d[m][n] = (d[m-1][n-1]||d[m-1][n]||d[m][n-1]);
                }else if(char_s==char_p||char_p=='?'){
                    d[m][n] = d[m-1][n-1];
                }else{
                    d[m][n]=false;
                }
            }
        }
        // for(int i=0;i<=s_length;i++){
        //     for(int j=0;j<=p_length;j++){
        //         System.out.print(d[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        return d[s_length][p_length];



        // if(s_length<=0 && p_length<=0) return true;
        // if(s_length>0&&p_length<=0) return false;
        // if(s_length<=0){
        //     for(int j=0;j<p_length;j++){
        //         if(p.charAt(j)!='*') return false;
        //     }
        //     return true;
        // }
        // if(s.charAt(0)==p.charAt(0)||p.charAt(0)=='?'){
        //     return isMatch(s.substring(1,s_length),p.substring(1,p_length));
        // }else if(p.charAt(0)=='*'){
        //     return isMatch(s,p.substring(1,p_length))||isMatch(s.substring(1,s_length),p)||isMatch(s.substring(1,s_length),p.substring(1,p_length));
        // }else{
        //     return false;
        // }
    }
}
// @lc code=end

