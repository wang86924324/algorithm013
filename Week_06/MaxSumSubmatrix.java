package homework.week6;

/**
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * 二维数组最大子序和
 * 1.暴力 O(N^4)
 * 2.DP
 * a.分治 problems(i1,j1,i,j)=dp(i1,j1,i-1,j)+dp(i1,j1,i,j-1)-dp(i1,j1,i-1,j-1)+a[i][j]
 * b. 状态定义
 * c. dp方程
 */
public class MaxSumSubmatrix {
//    public int maxSumSubmatrix(int[][] matrix, int k) {
//        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
//        int[][][][] dp = new int[rows + 1][cols + 1][rows + 1][cols + 1]; // from (i1,j1) to (i2,j2)
//        for (int i1 = 1; i1 <= rows; i1++) {
//            for (int j1 = 1; j1 <= cols; j1++) {
//                dp[i1][j1][i1][j1] = matrix[i1 - 1][j1 - 1];
//                for (int i2 = i1; i2 <= rows; i2++) {
//                    for (int j2 = j1; j2 <= cols; j2++) {
//                        dp[i1][j1][i2][j2] = dp[i1][j1][i2 - 1][j2] + dp[i1][j1][i2][j2 - 1] - dp[i1][j1][i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
//                        if (dp[i1][j1][i2][j2] <= k && dp[i1][j1][i2][j2] > max) max = dp[i1][j1][i2][j2];
//                    }
//                }
//            }
//        }
//        return max;
//    }

    // 前缀和
    // sum[i,j]=
    public int maxSumSubmatrix2(int[][] matirx, int k) {
        return 0;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //
                if (j > 0)
                    matrix[i][j] += matrix[i][j - 1];
            }
        }//按行求和
        int max = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //取出矩阵每一个点作为窗口起始点

                //滑动窗口
                for (int l = j; l < n; l++) {
                    sum = 0;
                    for (int h = i; h < m; h++) {//h代表窗口滑动的行数
                        if (j == 0)
                            sum += matrix[h][l];
                        else
                            sum += matrix[h][l] - matrix[h][j - 1];
                        if (sum <= k && sum > max)
                            max = sum;
                    }
                }
            }
        }
        return max;
    }
}
