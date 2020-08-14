package Week_03;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */


/**
 * https://leetcode-cn.com/problems/combinations/
 * 思路:
 * 1.DFS
 * 2.BFS
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (path.contains(i)) continue;
            path.add(i);
            dfs(n, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }


}
