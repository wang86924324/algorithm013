package homework.week6.tuesday;

import homework.week5.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 1.DFS
 * 2.BFS
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null) return res;
        StringBuilder path = new StringBuilder();
        dfs(root, path, res);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder path, List<String> res) {

        // current logic
        path.append("->" + root.val);

        // terminate
        if (root.left == null && root.right == null) {
            res.add(path.substring(2));
            return;
        }

        // trill down
        if (root.left != null) {
            dfs(root.left, path, res);
            path.delete(path.lastIndexOf("->"), path.length());
        }

        if (root.right != null) {
            dfs(root.right, path, res);
            path.delete(path.lastIndexOf("->"), path.length());
        }
    }
}
