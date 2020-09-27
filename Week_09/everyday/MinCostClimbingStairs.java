package Week_09.everyday;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/ 理解题意： 1.从某个i台阶跳一步或者两步的花费是nums[i] 2.最小的代价来跳出数组。
 * <p>
 * 状态：f[n]为跳到第n步的代价
 * <p>
 * 状态转移：f(n)=min(f(n-1)+a[n-1],f(n-2)+a[n-2]) 初始状态：f(0)=a[0] f(1)=min(a[0],a[1])
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[len];
    }
}
