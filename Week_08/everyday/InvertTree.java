package Week_08.everyday;

import common.TreeNode;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 先翻转左右节点
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;

        return root;
    }
}
