package homework.week6.tuesday;

/**
 * rob
 * https://leetcode-cn.com/problems/house-robber-ii/description/
 *
 * dp[n]=max(dp[n-1],dp[n-2]+n);
 *
 * 环形：dp[0,n]=max(dp[0,n-1],dp[1,n])
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int pre1 = 0, pre2 = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }
}
