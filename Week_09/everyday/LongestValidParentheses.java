package Week_09.everyday;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * <p>
 * 1.暴力法 双重循环，判断是否是有效括号 2.动态规划  类似子序列问题。
 */
public class LongestValidParentheses {

    // 1.状态：dp[i] 以下标i为结束字符的最长有效字符串的长度
    // 2.状态转移方程：
    // 2.1 s[i]='('  dp[i]=0;
    // 2.2 s[i]=')'
    // 2.2.1 s[i-1]='(' dp[i]=dp[i-2]+2
    // 2.2.2 s[i-1]=')' if dp[i-dp[i-1]-1]='(' then dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2]
    //
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        char[] arr = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (arr[i] == '(') {
                continue;
            }
            if (arr[i - 1] == '(') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if (i - dp[i - 1] > 0 && arr[i - dp[i - 1] - 1] == '(') {
                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

//    public int longestValidParentheses(String s) {
//        int max = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1); // 插入参照物，索引从0开始，索引-参照物=长度
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') { // 左括号的索引，入栈
//                stack.push(i);
//            } else {     // 遍历到有括号
//                stack.pop();   // 匹配到左括号，出站
//                if (stack.empty()) { // 栈空了，再次插入参照物，代替期初的参照物-1
//                    stack.push(i);
//                } else {
//                    max = Math.max(max, i - stack.peek());
//                }
//            }
//        }
//        return max;
//    }
//
//    public int longestValidParentheses(String s){
//        int max = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1); // 插入参照物-1
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)=='(') stack.push(i);
//            else {
//                stack.pop();
//
//                // 为空就更新参照物
//                if(stack.empty()){
//                    stack.push(i);
//                }
//                // 非空，挑战最长长度
//                else {
//                    max = Math.max(max,i-stack.peek());
//                }
//            }
//        }
//
//        return max;
//    }
}
