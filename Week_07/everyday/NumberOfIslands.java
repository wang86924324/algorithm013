package homework.week7.everyday;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (grid[i][j] == '0') continue;
            // 扫雷
            dfs(grid, i, j,m,n);
            count++;
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j,int m,int n) {
        if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == '0') return;
        grid[i][j]='0';
        for (int[] d : directions) dfs(grid, i + d[0], j + d[1],m,n);
    }
}
