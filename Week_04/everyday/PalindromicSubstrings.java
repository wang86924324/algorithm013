package homework.week4.everyday;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输入的字符串长度不会超过 1000 。
 * 通过次数38,350提交次数61,053
 */

/**
 * 1.暴力法
 * 2.动态规划
 */
public class PalindromicSubstrings {

//    int count = 0;
//
//    public int countSubstrings(String s) {
//        char[] chars = s.toCharArray();
//        boolean[] visited = new boolean[chars.length];
//        String path = "";
//        dfs(chars, path, visited);
//        return count;
//    }
//
//    private void dfs(char[] chars, String path, boolean[] visited) {
//        if (path.length() > 0) {
//            if (isPalindromic(path)) count++;
//            return;
//        }
//
//        for (int i = 0; i < chars.length; i++) {
//            if (visited[i]) continue;
//            visited[i] = true;
//            dfs(chars, path + chars[i], visited);
//            visited[i] = false;
//        }
//
//    }
//    // 双指针 省
//    private boolean isPalindromic(String str) {
//        return true;
//    }


    public int countSubstrings(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++)
            for (int i = 0; i <= j; i++) {
                if (j == i) dp[i][j] = true;
                else if (j - i == 1) dp[i][j] = s.charAt(i) == s.charAt(j);
                else dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);

                count += dp[i][j] ? 1 : 0;
            }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().countSubstrings("aaa"));
    }


}
