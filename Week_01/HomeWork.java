package Week_01;

public class HomeWork {

    // https://leetcode-cn.com/problems/rotate-array/
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) a[(i + k) % nums.length] = nums[k];
        for (int i = 0; i < nums.length; i++) nums[i] = a[i];
    }

    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
    //　fast and slow pointer
    //  loop fast pointer and maitain slow poistion
    // slow position is always begin with -1
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int slow = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) nums[++slow] = nums[i];
        }
        return slow + 1;
    }
}
