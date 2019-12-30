import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        String result = "";
        int a[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i=0;i<a.length;i++){
            while(num>=a[i]){
                result  = result + map.get(a[i]);
                num = num - a[i];
            }
        }
        return result;
    }
}
// @lc code=end

