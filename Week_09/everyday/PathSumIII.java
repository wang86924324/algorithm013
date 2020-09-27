package Week_09.everyday;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/ 1.dfs 2.起点可以是任何一个节点 3.必须是父节点到子节点
 * <p>
 * 1.外层是dfs或者bfs，确定起点。 2.内层是已起点为根节点，计算路径和。
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    int helper(TreeNode root, int sum){
        if(root == null) return 0;
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + helper(root.left, sum) + helper(root.right, sum);
    }


}
