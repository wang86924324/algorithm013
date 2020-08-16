package Week_03;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */

import org.omg.CORBA.INTERNAL;

/**
 * 1.中序遍历
 * 2.递归比较
 */
public class ValidBST {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }


    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer leftMax, Integer rightMin) {
        if (root==null) return true;

        // process cur
        if (leftMax != null && root.val <= leftMax) return false;
        if (rightMin != null && root.val >= rightMin) return false;


        return helper(root.left, leftMax, root.val) && helper(root.right, root.val, rightMin);

    }


}