package homework.week7.everyday;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {
    // 1.暴力，双重循环 O(N^2)  1.固定i指针，移动j从i开始移动到数组尾部，会产生i->j的区间的sum，并记录最大值。
    // 2.DP 假设知道前i个元素的最大值，最后一个元素加或者不加
    // dp[i]=Math.max(0,dp[i-1])+nums[i]
    // 初始值：dp[0]=nums[0];
//    public int maxSubArray(int[] nums) {
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                max = j == 0 ? sum : Math.max(max, sum);
//            }
//        }
//        return max;
//    }

    // dp[i]标识nums中以nums[i]结尾的最大子序和
    // dp[i]=max(dp[i-1]+nums[i],nums[i])   选择：要选择跟前面的最大值相加、要么不跟前面的最大值相加
    // 初始值：dp[0]=nums[0]
    // 时间复杂度o(N) 控件复杂度(O(N)) 由于递归公式只跟前面一个元素相关，可以优化到o(1)
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
