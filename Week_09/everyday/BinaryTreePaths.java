package Week_09.everyday;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        dfs(root, path, res);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder path, List<String> res) {
        // teminate
        if (root.left == null && root.right == null) {
            path.append("->" + root.val);
            res.add(path.substring(2));
            path.delete(path.lastIndexOf("->"), path.length());
            return;
        }
        // current logic
        path.append("->" + root.val);

        // dirll down
        if (root.left != null) {
            dfs(root.left, path, res);
        }
        if (root.right != null) {
            dfs(root.right, path, res);
        }
        // reverse state
        path.delete(path.lastIndexOf("->"), path.length());
    }
}