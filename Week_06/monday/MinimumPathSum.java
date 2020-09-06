package homework.week6.monday;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * 切题:
 * 1.只能向下，向右
 * 2.最小路径和,非负整数
 * 3.空数组：返回0，1行或者一列，直接相加
 * <p>
 * 思路：
 * 1.暴力 求最小值
 * 2.DP
 * （1）最优解 （2）最优子结构 考虑使用动态规划。
 * DP方程：dp[m,n]=Min(dp[m-1][n]+dp[m][n-1])+a[m][n]  dp[m][n]标识从{0,0}位置走到{m,n}位置的最小路径和。
 * 初始值：dp[0][0]=a[0][0]
 */
public class MinimumPathSum {
//    public int minPathSum(int[][] grid) {
//        if (grid.length == 0 || grid[0].length == 0) return 0;
//
//        int m = grid.length, n = grid[0].length;
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
//            dp[i][j] = getMin(dp, i, j) + grid[i][j];
//        }
//        return dp[m - 1][n - 1];
//    }
//
//    private int getMin(int[][] dp, int i, int j) {
//        if (i == 0 && j == 0) return 0;
//        if (i == 0) return dp[i][j - 1];
//        if (j == 0) return dp[i - 1][j];
//        return Math.min(dp[i - 1][j], dp[i][j - 1]);
//    }

    // 一维滚动数组
//    public int minPathSum(int[][] grid) {
//        if (grid.length == 0 || grid[0].length == 0) return 0;
//
//        int m = grid.length, n = grid[0].length;
//        int[] dp = new int[n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[j]=Math.min(dp[j],dp[j-1])+grid[i][j];
//            }
//        }
//
//        return dp[n-1];
//    }

    // 1.暴力
    // 2.DP  dp[j]=Math.max(dp[j],dp[j-1])+grid[i][j] for i in grid.rowindexs
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                // j==0 不做任何处理;i==0|| 上一个元素大于当前元素，更新当前元素
                if (j > 0 && (i == 0 || dp[j - 1] < dp[j])) {
                    dp[j] = dp[j - 1];
                }
                dp[j] += grid[i][j];
            }
        return dp[n - 1];
    }


}
