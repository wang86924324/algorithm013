package homework.week6;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 1.暴力 枚举所有的起点和重点
 * 2.DP
 * a.分治  max_sum(i)=max(max_sum(i-1),0)+a[i]
 * b.状态数组定义：f[i]=max(f[i-1],0)+a[i]
 * c.dp方程 f[i]=max(f[i-1],0)+a[i]
 * <p>
 * 最大子序列：当前元素最大、包含当前元素最大。
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
