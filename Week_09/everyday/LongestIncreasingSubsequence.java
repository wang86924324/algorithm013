package Week_09.everyday;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p>
 * 状态：dp[i]以i结尾的最长上身子序列的长度  经验，记忆 状态转移方程：max(dp[j]+1)| nums[j]<nums[i] & j<i (类似爬楼梯，每阶楼梯有要给数字，跳过的数字递增，求可以跳最长的步数) 初始值：dp[1]=1;
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int steps : dp) {
            res = Math.max(res, steps);
        }
        return res;
    }
}
