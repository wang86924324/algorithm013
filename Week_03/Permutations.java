package Week_03;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), res, hasVisited);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] hasVisited) {
        // terminate condition
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            // process current logic
            if (hasVisited[i]) continue;
            hasVisited[i] = true;
            path.add(nums[i]);

            // drill down
            dfs(nums, path, res, hasVisited);

            // reverse state
            path.remove(path.size() - 1);
            hasVisited[i] = false;
        }
    }
}