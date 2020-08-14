package Week_03;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 全排列专题
 * 题目	提示
 * 47. 全排列 II	思考一下，为什么造成了重复，如何在搜索之前就判断这一支会产生重复，从而“剪枝”。
 * 17 .电话号码的字母组合
 * 22. 括号生成	这是字符串问题，没有显式回溯的过程。这道题广度优先遍历也很好写，可以通过这个问题理解一下为什么回溯算法都是深度优先遍历，并且都用递归来写。
 * 39. 组合总和	使用题目给的示例，画图分析。
 * 40. 组合总和 II
 * 51. N皇后	其实就是全排列问题，注意设计清楚状态变量。
 * 60. 第k个排列	利用了剪枝的思想，减去了大量枝叶，直接来到需要的叶子结点。
 * 77. 组合	组合问题按顺序找，就不会重复。并且举一个中等规模的例子，找到如何剪枝，这道题思想不难，难在编码。
 * 78. 子集	为数不多的，解不在叶子结点上的回溯搜索问题。解法比较多，注意对比。
 * 90. 子集 II	剪枝技巧同 47 题、39 题、40 题。
 * 93. 复原IP地址
 * 784. 字母大小写全排列
 */
public class Permute {
    // DFS
    // BFS
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        dfs(nums, hasVisited, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, boolean[] hasVisited, ArrayList<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (hasVisited[i]) continue;
            // current logic
            path.add(nums[i]);
            hasVisited[i] = true;

            // drill down
            dfs(nums, hasVisited, path, res);

            // reverse states
            path.remove(path.size() - 1);
            hasVisited[i] = false;
        }
    }


}
