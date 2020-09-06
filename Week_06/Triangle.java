package homework.week6;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/description/
 * <p>
 * 切题：
 * 1.边界 空  0
 * 2.把三角形看成二叉树的话，就是求从根节点到叶子节点的所有路径和的最小值
 * <p>
 * <p>
 * 解决思路：
 * 1.DFS BFS遍历所有可能的路径，求最小值
 * 假设root = triange[i][j] left=triangle[i+1][j] right=triangle[i+1][j+1]
 * DP方程：dp[root]=min(dp[left],dp[right])+root.value
 * 初始值：i,j是叶子节点，那么dp[i][j]=triangle[i][j]
 * <p>
 * 状态压缩：dp[j]+=dp[j+1];
 */
public class Triangle {
    // dp要点
    // dp方程：dp[j]=min(dp[j],dp[j+1])+a[i][j];
    // 细节点：1.倒序递推  2.第行的最大索引为i
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }


}
