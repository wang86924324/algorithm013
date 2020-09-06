package homework.week6;

/***
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 1.子问题
 * 选择：a[m]!=b[n] max_sum(m,n)=max(max_sum(m-1,n),max_sum(m,n-1))
 *  a[m]==b[n] max_sum(m,n)=max_sum(m-1,n-1)+1
 *  2.状态 dp[m][n] a数组的前m个元素和b数组中前n个元素的最长公共子序列
 *  3.dp方程： dp[m][n]={dp[m-1][n-1]+1(a[m]=b[n])|max(dp[m-1][n],dp[m][n-1])}
 *  4.初始状态 dp[0][j]=0 |j=0,1...n dp[i][0]=0 | i=0,1,2...m
 *
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        return dp[m][n];
    }
}
