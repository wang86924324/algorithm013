package Week_09.lession1;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * 1.dp[i]爬到第i层楼梯需要的最下步骤数
 * 2.dp[i]=min(dp[i-1]+a[i-1],dp[i-2]+a[i-2]) 可以选择从第i-1步，或者第i-2步跳过  数组长度为n，那么楼顶就是n+1
 * 3.初始值 dp[0]=0 dp[1]=0;
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
