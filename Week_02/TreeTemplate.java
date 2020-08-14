package Week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTemplate {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
    // 思路：一般按照出栈的顺现金打印出来。
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty() || cur != null) {
            // 根->左节点的顺序压入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 栈顶元素的左节点为空，栈顶元素出栈
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty() || cur != null) {
            // 根->右节点的顺序压入栈
            while (cur != null) {
                stack.push(cur);
                res.add(cur.val);
                cur = cur.right;
            }
            // 栈顶元素的左节点为空，栈顶元素出栈
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.left;
        }

        return res;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty() || cur != null) {
            // 根->左节点的顺序压入栈
            while (cur != null) {
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }
            // 栈顶元素的左节点为空，栈顶元素出栈
            cur = stack.pop();
            cur = cur.left;
        }

        return res;
    }

}
