package homework.week6.thursday;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecodings {
    // 切题
    // 1.边界：空、0开头  返回0
    // 2.计算总数
    // 考虑：斐波拉契数列
    // f(n)+=f(n-1) | s[n]能单独编码
    // f(n)+=f(n-2) | s[n-1,n]可以一起编码
    // 先写递归式
    // 再写地推式
//    public int numDecodings(String s) {
//        // 边界处理
//        if (s.length() == 0 || s.charAt(0) == '0') return 0;
//        return helper(s.toCharArray(), s.length() - 1);
//    }
//
//    private int helper(char[] nums, int index) {
//        // terminate
//        if (index <= 0) return 1;
//
//        // 第一步
//        int count = 0;
//        if (nums[index] != '0') count = helper(nums, index - 1);
//
//        // 第二步 假设s=12的时候，第二步count+=1，也就是说helper(nums,-1)=1
//        int num = 10 * (nums[index - 1] - '0') + (nums[index] - '0');
//        if (10 <= num && num <= 26) count += helper(nums, index - 2);
//
//        return count;
//    }

    /**
     * // 递推式
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;

        char[] nums = s.toCharArray();
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            // 第一步(i可以编码)
            if (nums[i] != '0') dp[i] = dp[i - 1];
            // 第二步 [i-1,i]可以编码
            int num = 10 * (nums[i - 1] - '0') + (nums[i] - '0');
            if (10 <= num && num <= 26) {
                dp[i] += i == 1 ? 1 : dp[i - 2];
            }

        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("10"));
    }
}
