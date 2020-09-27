package Week_09.everyday;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum/
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        // teminate
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }

        if (root.left != null && hasPathSum(root.left, sum - root.val)) return true;
        if (root.right != null  && hasPathSum(root.right, sum - root.val) ) return true;
        return false;
    }
}
