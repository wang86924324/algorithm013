package Week_010.everyday;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * <p>
 * 1.非空   非负整数 逆序  1位数字
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int nextAdd = 0;
        ListNode dummy = new ListNode(-1);
        ListNode first, second, head;
        for (first = l1, second = l2, head = dummy; first != null && second != null; first = first.next, second = second.next, head = head.next) {
            head.next = new ListNode((first.val + second.val + nextAdd) % 10);
            nextAdd = (first.val + second.val + nextAdd) / 10;
        }
        for (; first != null; first = first.next, head = head.next) {
            head.next = new ListNode((first.val + nextAdd) % 10);
            nextAdd = (first.val + nextAdd) / 10;
        }

        for (; second != null; second = second.next, head = head.next) {
            head.next = new ListNode((second.val + nextAdd) % 10);
            nextAdd = (second.val + nextAdd) / 10;
        }
        if (nextAdd > 0) {
            head.next = new ListNode(nextAdd);
        }
        return dummy.next;
    }
}
