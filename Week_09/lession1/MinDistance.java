package Week_09.lession1;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class MinDistance {

    // dp[i][j] word1.sub(0,i)与word2.subString(0,j)之间的边界距离
    // dp[i][j]=dp[i-1][j-1] if(word1[i]=word2[j])
    // else dp[i][j]=min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1
    // 初始状态：空串跟任何字符串的边界距离的等于字符串的长度
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("horse", "ros"));


    }

//    public int minDistance(String word1, String word2) {
//        int m = word1.length(), n = word2.length();
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 0; i <= m; i++) {
//            dp[i][0] = i;
//        }
//        for (int j = 0; j <= n; j++) {
//            dp[0][j] = j;
//        }
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i][j - 1])) + 1;
//                }
//            }
//        }
//
//        return dp[m][n];
//    }
}
