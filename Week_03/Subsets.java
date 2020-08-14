package Week_03;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, i, 0, subsets, new ArrayList<>());
        }
        return subsets;
    }

    private void dfs(int[] nums, int count, int start, List<List<Integer>> res, List<Integer> subset) {
        // teminate
        if (count == subset.size()) {
            res.add(subset);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            //process current logic
            subset.add(nums[i]);
            // drill down
            dfs(nums,count,i+1,res,subset);
            //reverse states
            subset.remove(subset.size() - 1);
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        return helper(lists,0,lists.length-1);
    }

    private ListNode helper(ListNode[] lists,int left,int right){
        if(right==left) return lists[left];
        int middle = (left+right)/2;
        ListNode first = helper(lists,left,middle);
        ListNode second = helper(lists,middle+1,right);
        return mergeTwoList(first,second);
    }

    private ListNode mergeTwoList(ListNode first,ListNode second){
        if(first==null) return second;
        if(second==null) return first;

        if(first.val<second.val){
            first.next = mergeTwoList(first.next,second);
            return first;
        }

        second.next= mergeTwoList(first,second.next);
        return second;
    }


}
