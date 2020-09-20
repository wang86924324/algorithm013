package Week_08.everyday;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * <p>
 * 关键：相邻不能偷,非负数 1. 类似走台阶 f(n)=max(f(n-1),f(n-2)+a[n]) 初始条件：f(1)=a[0],f(0)=0.
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[nums.length];
    }


}
