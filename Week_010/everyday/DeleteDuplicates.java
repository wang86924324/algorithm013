package Week_010.everyday;

import common.ListNode;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        for (ListNode fast = head.next; fast != null; fast = fast.next) {
            if (fast.val != slow.val) {
                slow.next = fast;
            }
        }
        slow.next = null;

        return slow;
    }
}
