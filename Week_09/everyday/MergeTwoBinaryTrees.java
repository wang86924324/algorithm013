package Week_09.everyday;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {

//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if (t1 == null) {
//            return t2;
//        }
//        if (t2 == null) {
//            return t1;
//        }
//
//        TreeNode merged = new TreeNode(t1.val + t2.val);
//        t1.left = mergeTrees(t1.left, t2.left);
//        t2.right = mergeTrees(t1.right, t2.right);
//        return merged;
//    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null) return t2;
        if(t2==null) return  t1;
        TreeNode cur = new TreeNode(t1.val+t2.val);
        cur.left=mergeTrees(t1.left,t2.left);
        cur.right=mergeTrees(t1.right,t2.right);
        return cur;
    }
}
