package homework.week7.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(combinations, combination, k, n, 1);

        return combinations;
    }

    private void dfs(List<List<Integer>> combinations, List<Integer> combination, int k, int n, int start) {
        // teminate
        if (n == 0 && combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
        }

        for (int i = start; i <= 9; i++) {
            if (combination.size() == k || n == 0) continue;

            combination.add(i);
            dfs(combinations, combination, k, n - i, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
