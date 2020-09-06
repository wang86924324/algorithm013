package homework.week6.monday;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int m = obstacleGrid.length, n = obstacleGrid[0].length;
//        int[] dp = new int[n];
//        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
//        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++){
//            if(obstacleGrid[i][j]==1){
//                dp[j]=0;
//            }
//            else if(j-1>=0 && obstacleGrid[i][j-1] == 0) {
//                dp[j]+=dp[j-1];
//            }
//        }
//        return dp[n-1];
//    }

    // 地推方程： 模板地推：dp[j]+=dp[j-1]|j>0 （理解记忆）
    // 初始化 dp[0]=grid[0][0]==1?0:1;
    // 障碍物：if(grid[i][j]==1) dp[j]==0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[j] = 0;
                else if (j > 0) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        return dp[n - 1];
    }
}

