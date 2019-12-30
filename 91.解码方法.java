/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if(s.startsWith("0")) return 0;
        int s_length = s.length();
        int d[] = new int[s_length+1];
        d[0]=1;
        d[1]=1;
        HashSet<String> middle = new HashSet<String>();
        for(int i=1;i<=26;i++){
            middle.add(i+"");
        }

        for(int j=2;j<=s_length;j++){
            String subsString = s.substring(j-2,j);
            String subString2 = s.substring(j-1,j);
            System.out.println(subsString);
            System.out.println(subString2);
            // int cur = Integer.parseInt(subsString);
            // int cur2 = Integer.parseInt(subString2);
            if(middle.contains(subsString)&&middle.contains(subString2)){
                d[j]=d[j-2]+d[j-1];
                // System.out.println("com3");
            }else if(!middle.contains(subsString)&&!middle.contains(subString2)){
                return 0;
            }else if(middle.contains(subsString)){
                // System.out.println("come");
                d[j-1]=d[j-2];
                d[j]=d[j-1];
            }else{
                // System.out.println("com2");
                d[j]=d[j-1];
            }
        }
        // System.out.println(middle);
        return d[s_length];
    }
}
// @lc code=end

