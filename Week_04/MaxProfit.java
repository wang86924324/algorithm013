package homework.week4;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 1.暴力法
 * 2.贪心算法
 * 3.动态规划
 */
public class MaxProfit {
//    int res = 0;
//
//    public int maxProfit(int[] prices) {
//        if (prices.length < 2) return 0;
//        int index = 0;
//        int profit = 0;
//        int status = 0;
//        dfs(prices, index, status, profit);
//        return res;
//    }
//
//    private void dfs(int[] prices, int index, int status, int profit) {
//        if (index == prices.length) {
//            res = Math.max(res, profit);
//            return;
//        }
//
//        // 不操作
//        dfs(prices, index + 1, status, profit);
//
//        // 买入/卖出
//        if (status == 0) {
//            dfs(prices, index + 1, 1, profit - prices[index]);
//        } else {
//            dfs(prices, index + 1, 0, profit + prices[index]);
//        }
//    }


//    public int maxProfit(int[] prices) {
//        if (prices.length < 2) return 0;
//
//        int res = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            if (prices[i] < prices[i + 1]) {
//                res += prices[i + 1] - prices[i];
//            }
//        }
//        return res;
//    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        // 0-持有现金 1-持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][i] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

}
