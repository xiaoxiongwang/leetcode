import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */
class Solution {
    
}


class Test{
    public static String add_length(String s)
    {
        String regex = "(.{1})";
        String new_s = s.replaceAll(regex, "$1#");
        return "#"+new_s;

    }
    public static String longestPalindrome(String s) {
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
                System.out.println("i="+i);
                char x1 = new_s.charAt(i+len[i]),x2 = new_s.charAt(i-len[i]);
                System.out.println("---------------------------");
                System.out.println(i-len[i]);
                System.out.println(i+len[i]);
                System.out.println(x1);
                System.out.println(x2);
                System.out.println(x1==x2);
                System.out.println((byte)x1);
                System.out.println((byte)x1);
                System.out.println((byte)x1==(byte)x2);
                System.out.println("---------------------------");

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
        // return s;
    }
    public static int reverse(int x) {
        
        int sign = x<0?-1:1;
        if(sign==-1) x=-x;
        // System.out.println(Integer.MAX_VALUE);
        // System.out.println(Integer.MIN_VALUE);
        long result = 0;
        while(x!=0)
        {
            result = result*10 + x%10;
            x /= 10;
        }
        if(result>=Integer.MAX_VALUE) return 0;
        return (int)result*sign;
    }
    public static int myAtoi(String str) {
        String result = str.trim();
        if(result.length()==0) return 0;
        char start = result.charAt(0);
        if(start!='+'&&start!='-'&&!Character.isDigit(start)) return 0;

        Pattern p = Pattern.compile("^[+-]?\\d+");
        Matcher m = p.matcher(str);
        String s = "";
        if(m.find())
        {
            s = m.group(0);
            s = s.replace("+","") ;
            
        }else{
            return 0;
        }
        if(s.length()>11) return Integer.MAX_VALUE;
        long resul = Long.parseLong(s);
        if(resul>Integer.MAX_VALUE||resul<Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return Integer.parseInt(s);
        
    }
    public static void main(String[] args) { 
        String s = "  0000000000012345678";
        s = s.trim();
        System.out.println(s.replaceAll("^[+-]?[0]{1,}", ""));
        System.out.println(myAtoi("   -42"));
        System.out.println(Integer.MAX_VALUE);
        // HashMap<Integer,Integer> m = new HashMap<>();
        // int x = 3;
        // m.put(x, 5);
        // System.out.println(m.get(x));
        // System.out.println("test");

        // String s = "helloworld";
        // String regex = "(.{1})";
        // String new_s = s.replaceAll(regex, "$1#");
        // System.out.println("#"+new_s);

        // String test = "babad";
        // System.out.println(test.charAt(arg0));
        // ArrayList a = new ArrayList<>();
        // a.add(1);
        // a.add(2);
        // System.out.println(a.get(0));
        // System.out.println(a.get(1));
        // System.out.println(a.size());
        // int x=-123;
        // System.out.println(x%100);
        // int x = -2147483648;
        // System.out.println(reverse(x));
        // String s = "  dshaj-+23157sagd-21312   ";
        // System.out.println(s.trim());
        // Pattern p = Pattern.compile("[+-]?\\d+");
        // Matcher m = p.matcher(s);
        
        // if(m.find())
        // {
        //     System.out.println(m.group(0));
        // }

        // System.out.println(Integer.parseInt("-123678"));
        // System.out.println(longestPalindrome(test));
    }
}