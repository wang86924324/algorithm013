package Week_08.everyday;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {
    // 假设第三个和后面的已经完成swap
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode second = head.next;
        head.next=swapPairs(second.next);
        second.next=head;
        return second;
    }
}
