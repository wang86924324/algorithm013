package homework.week6.tuesday;

import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 1.切题
 * 要点：
 * <p>
 * 思路：coins不是倍数关系，不能使用贪心算法。
 * 1.暴力法（BFS）
 * 2.求最值，考虑动态规划：
 * 2.1 重叠子问题、最优子结构，状态转移方程
 * 2.1 基本问题->状态->选择  dp函数
 * dp[n]=0,n=0
 * dp[n]=-1,n<0
 * dp[n]=min{dp[n-coin]+coin|coin属于coins},n>0
 */
public class CoinChange {
    // 递归
//    public int coinChange(int[] coins, int amount) {
//        if (amount < 0) return -1;
//        if (amount == 0) return 0;
//        int min = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int sub=coinChange(coins,amount-coin);
//            if(sub==-1) continue;
//            min = Math.min(min,sub);
//        }
//        return min;
//    }

//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, amount + 1);
//        dp[0]=0;
//        for (int i = 1; i <= amount; i++) {
//            for (int coin : coins) {
//                if (i < coin) continue;
//                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//            }
//        }
//        // 为什么会大于amount
//        return dp[amount] > amount ? -1 : dp[amount];
//    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;  // 初始化值为0
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount];
    }


//    public class Solution {
//        public int coinChange(int[] coins, int amount) {
//            int max = amount + 1;
//            int[] dp = new int[amount + 1];
//            Arrays.fill(dp, max);
//            dp[0] = 0;
//            for (int i = 1; i <= amount; i++) {
//                for (int j = 0; j < coins.length; j++) {
//                    if (coins[j] <= i) {
//                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                    }
//                }
//            }
//            return dp[amount] > amount ? -1 : dp[amount];
//        }
//    }


}
