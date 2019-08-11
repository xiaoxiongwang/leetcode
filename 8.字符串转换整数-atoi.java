import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */
class Solution {
    public int myAtoi(String str) {
        String result = str.trim();
        if(result.length()==0) return 0;
        char start = result.charAt(0);
        if(start!='+'&&start!='-'&&!Character.isDigit(start)) return 0;

        Pattern p = Pattern.compile("^[+-]?\\d+");
        Matcher m = p.matcher(result);
        String s = "";
        int flag = 1;
        if(m.find())
        {
            s = m.group(0);
            s = s.replace("+","") ;
            if(s.contains("-")) flag = -1;

            s = s.replaceAll("^[+-]?[0]{1,}", "");


            if(s.length()==0) return 0;
            if(flag==-1&&!s.contains("-")) s = "-"+s;

            // Pattern p2 = Pattern.compile("^[+-]?[0]{1,}");
            // Matcher m2 = p2.matcher(s);

            // if()
        }else{
            return 0;
        }
        if(s.length()>11)
        {
            if(flag==1)
                return Integer.MAX_VALUE;
            if(flag==-1)
                return Integer.MIN_VALUE;
        }
        long resul = Long.parseLong(s);
        if(resul>Integer.MAX_VALUE||resul<Integer.MIN_VALUE){
            if(flag==1) return Integer.MAX_VALUE;
            if(flag==-1) return Integer.MIN_VALUE;
        } 
        return Integer.parseInt(s);
        
    }
}

