package homework.week4.everyday;

import homework.week4.ListNode;
import homework.week4.TreeNode;

public class EveryDay {
    // 分治
    public TreeNode sortedListToBST(ListNode head) {
        ListNode left = head;
        ListNode right = null;
        return buildTree(left, right);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }

        ListNode middle = getMiddle(left, right);
        TreeNode cur = new TreeNode();
        cur.val = middle.val;
        cur.left = buildTree(left, middle);
        cur.right = buildTree(middle.next, right);

        return cur;
    }

    private ListNode getMiddle(ListNode left, ListNode right) {
        ListNode slow = left, fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
