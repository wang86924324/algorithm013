package homework.week7.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String path = "";

        dfs(0, 0, n, path, res);
        return res;
    }

    private void dfs(int left, int right, int n, String path, List<String> res) {
        // terminate
        if (left == n && right == n) res.add(path);
        if (left < n) dfs(left + 1, right, n, path + "(", res);
        if (right < left) dfs(left, right + 1, n, path + ")", res);
    }
}
