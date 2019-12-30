import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int s_length = s.length();
        // int d[] = new int[s_length];
        LinkedList<Integer> stack = new LinkedList<>();
        int index = 0;
        int max = 0;
        for(int i=0;i<s_length;i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    index = i+1;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max, i-index+1);
                    }else{
                        max = Math.max(max,i-stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
// @lc code=end

