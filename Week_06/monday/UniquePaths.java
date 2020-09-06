package homework.week6.monday;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 切题：
 * 1.m*n的网格
 * 2.向右或者向下
 * 3.总个路径树
 * <p>
 * 思路：
 * 1.DFS
 * 2.动态规划
 * 1.
 * 状态定义：dp[m][n]标识从[0,0]到[m,n]路径和
 * 状态方程：dp[m][n]=dp[m-1][n](向下)+dp[m][n-1]（向右）
 * 初始状态：第一行都为1
 * 状态压缩：dp[i][j]=dp[i][j-1]+dp[i-1][j]当遍历在第i上的时候，前面的状态是无效的，可以考虑状态压缩。
 * 如果只用一维数组，那么遍历到第i行的时候，dp[i][j],dp[i,j-1]等价于dp[j]，dp[j-1],dp[i-1][j]是上一行的dp[j]，还保存在j位置。
 * 所以压缩公式为dp[j]=dp[j-1](当前行)+dp[j]（上一行）==》dp[j]+=dp[j-1]
 */
public class UniquePaths {
    // dp[j]+=dp[j-1]   初始化：第一行和第一列都是1
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<m;i++) for (int j=1;j<n;j++){
            dp[j]+=dp[j-1];
        }
        return dp[n-1];
    }
}
