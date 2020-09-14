package homework.week7.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 * 1.DFS 注意去重
 */
public class combinations {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(n, 1, k, path, res);
            return res;
        }

        private void dfs(int n, int start, int k, List<Integer> path, List<List<Integer>> res) {
            //  terminate
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i <= n; i++) {
                // current logic
                path.add(i);
                // dill down
                dfs(n, i + 1, k, path, res);
                // reverse state
                path.remove(path.size() - 1);
            }
        }
}
