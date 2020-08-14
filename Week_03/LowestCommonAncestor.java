package Week_03;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */

/**
 * 解题思路：
 * 前提：根节点应该是最大公共祖先
 *
 * 1.公共祖先逻辑：
 * 1.1要么在左右两边，各一个，要么在某一边
 * 1.2 左右两边个一个的话，返回当前节点。
 * 1.3 在其中一边，返回另外一个节点。
 * 递归终止条件：
 * 带着两个节点去左右子树去遍历，如果能遍历到其中一个节点，那么说明左右子树存在其中一个节点。
 *
 * 当前节点处理（联想3个节点的情况，做归纳）：
 * 如果在两边，做节点的递归结果和右子树的递归结果都部位空，说明当前节点为公共祖先。
 * 如果都为空，则返回空
 * 如果一个部位空，那么就返回另外一个
 * 补充售卖：由于递归是自顶向下的，寻找公共父节点的权利会下方，所以递归查询出出来的就是最近公共祖先
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
