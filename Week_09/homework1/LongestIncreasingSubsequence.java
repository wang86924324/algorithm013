package Week_09.homework1;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p> 1.切题  无须，子序列（可以不连续） 最长 上升
 * <p> 2.分析
 * <p> 2.1 暴力解法  O(N3)
 * <p> 2.2 最长，考虑动态规划
 * <p> 动态规范分析：
 * <p>1.状态定义  dp[i]以a[i]结尾的最长上升子序列，最后求max(dp[i])| i in (0,a.length)
 * <p>2.状态转移方程  dp[i]=dp[i-k]+1 if(a[k]<a[i] && a[k+1,i-1] > a[i])
 * <p>3.初始状态  初始状态 dp[0]=a[i]
 * </p>
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
