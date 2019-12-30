import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int result = 0;

        int start = 0;
        int end = s.length();

        while(start<end){
            // System.out.println(result);
            if(start==end-1){
                String substring2 = s.substring(start, start+1);
                result += map.get(substring2);
                start = start+1;
                continue;
            }
            String substring = s.substring(start, start+2);
            if(map.keySet().contains(substring)){
                result += map.get(substring);
                start = start+2;
            }else{
                String substring2 = s.substring(start, start+1);
                result += map.get(substring2);
                start = start+1;
            }
        }

        return result;
    }
}
// @lc code=end

