package homework.week6.thursday;

import homework.week5.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return res;
        res.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return res;
    }


    private TreeNode helper(int[] nums, int left, int right) {
        // teminate todo
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode();
        root.val = nums[mid];
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }


//    // 切题
//    // 1.空 0开头
//    // 2.分析：
//    // 2.1 f(n)+=f(n-1) 条件 s[n]!=0
//    // 2.1 f(n)+=f(n-2) 条件 s[n-1,n-2] in [10,26] 其中f(0)=1
//    public int numDecodings(String s) {
//        // 空 0
//        if (s.length() == 0 || s.charAt(0) == '0') return 0;
//        return helper(s.toCharArray(), s.length() - 1);
//    }
//
//    public int helper(char[] s, int index) {
//
//        // terminate
//        if (index == 0 || index == -1) return 1;
//
//        int res = 0;
//        // 第一步
//        if (s[index] != '0') res += helper(s, index - 1);
//
//        // 第二步
//        int num = 10 * (s[index - 1] - '0') + (s[index] - '0');
//        if (num >= 10 && num <= 26) {
//            res += helper(s, index - 2);
//        }
//
//        return res;
//    }





}
