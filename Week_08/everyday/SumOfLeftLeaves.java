package Week_08.everyday;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {

//    int count = 0;
//    public int sumOfLeftLeaves(TreeNode root) {
//        sumOfLeftLeaves(root, false);
//        return count;
//    }
//
//    public void sumOfLeftLeaves(TreeNode cur, boolean isleft) {
//        if (cur == null) return;
//        if(isleft&&cur.left==null && cur.right==null) count+=cur.val;
//        sumOfLeftLeaves(cur.left,true);
//        sumOfLeftLeaves(cur.right,false);
//    }
//

    public int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    private int dfs(TreeNode cur) {
        int res = 0;
        // 先加左子树的页面节点
        if (cur.left != null) {
            res += isleafNode(cur.left) ? cur.left.val : dfs(cur.left);
        }

        if (cur.right != null && !isleafNode(cur.right)) {
            res += dfs(cur.right);
        }
        return res;
    }

    private boolean isleafNode(TreeNode cur) {
        return cur.left == null && cur.right == null;
    }


}
