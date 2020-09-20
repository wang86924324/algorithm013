package Week_08.everyday;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 *
 * 1.假设i节点固定（外层循环），dp[j]为A[0...i-1]与B[0...j-1]，最长公共子序列，并且包含b【j-1】个元素。
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
