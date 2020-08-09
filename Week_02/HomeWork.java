package Week_02;


import java.util.*;

public class HomeWork {
    // https://leetcode-cn.com/problems/valid-anagram/description/
    // 1.先排序，再比较 时间复杂度O(N)
    // 2.hashMap统计  时间复杂度：O(N) 空间复杂度:O(N)
    // 3.26长度数组基数，一个指针遍历两个数组，一个记录整数，一个记录负数。
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
    }

    // 1.暴力  O(N^2)
    // 2.排序+双指针夹逼  O(nLogn)
    // 3.hashMap计数
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 1) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return new int[]{map.get(nums[i]), i};
            map.put(target - nums[i], i);
        }
        return new int[0];
    }


    // https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/submissions/
    // 1.递归
    // 2.栈
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return result;
        result.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return result;
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // 1.先排序,生成key，再分类 NKlogK  数组中最大子字符串的长度
    // 2.计算位置，生成key，再分类
    // https://leetcode-cn.com/problems/group-anagrams/
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
//        // 实现2：先排序，再分组  假设数组的中字符串最大长度为K，排序的时间复杂度是KlogK
//        Map<String, List<String>> map = new HashMap<>();
//        for (String s : strs) {
//            char[] chars = s.toCharArray();
//            Arrays.sort(chars);
//            String key = String.valueOf(chars);
//            if (!map.containsKey(key)) map.put(key, new ArrayList());
//            map.get(key).add(s);
//        }
//        return new ArrayList<>(map.values());

        // 实现3：生成key的规则，位置数组
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
    // 1.递归
    // 2.栈
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) return;
        inOrder(treeNode.left, res);
        res.add(treeNode.val);
        inOrder(treeNode.right, res);
    }
}
