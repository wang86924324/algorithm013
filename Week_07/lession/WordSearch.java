package homework.week7.lession;

/**
 * https://leetcode-cn.com/problems/word-search/
 */
public class WordSearch {
    int m, n;
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // 1.dfs
    // 2.每次4个方向扩散，并且判断扩散后端字符是跟第index单词相等，不相等的话，就终止扩散，相等的话，继续扩散。
    // 3.终止：当扩散完所有字符的时候，递归终止，返回为true。
    // 4.二维数组的每个点，都可以作为起点。
    // 5.为了防止重复扩散，需要记录已经扩散的位置，这个位置需要使用维度数组来标识，长宽和待搜索的矩阵的长宽一致。
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;

        m = board.length;
        n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            // 如果有一个为起点匹配成功，那么就返回成功。
            if (dfs(board, i, j, word, 0, hasVisited)) return true;
        }

        // 所有节点都没有匹配成功，那么返回失败
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] hasVisited) {
        // terminate:所有字符都匹配成功，那么返回true
        if (index == word.length()) return true;

        // cut leaf:当前层剪枝
        if(i<0 || i>=m || j<0 || j>=n || hasVisited[i][j] || word.charAt(index) != board[i][j]) return false;

        // current logic：当前层能匹配成功才能往下扩散，否则终止扩散，返回false
        //if(hasVisited[i][j] || word.charAt(index) != board[i][j]) return false;

        hasVisited[i][j]=true;
        for(int[] d:direction) {
            if(dfs(board,i+d[0],j+d[1],word,index+1,hasVisited)) return true;
        }
        hasVisited[i][j] = false;

        return false;
    }
}
