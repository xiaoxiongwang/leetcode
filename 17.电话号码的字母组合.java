import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    List<String> list = new LinkedList<String>();

    HashMap<Integer,String> map = new HashMap<Integer,String>();
        
    public List<String> letterCombinations(String digits) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

    }

    public String letterCombinations_middle(String digits){
        String result = "";
        int digit_len = digits.length();
        if(digit_len==0){
            
        }else if(digit_len==1){

        }else{

        }

        // result += letterCombinations_middle(digits.substring(1, digits.length()));

    }
}
// @lc code=end

