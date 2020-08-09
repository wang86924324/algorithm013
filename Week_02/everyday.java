package Week_02;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class everyday {
    Stack<Character> stack = new Stack<Character>();

    public String removeOuterParentheses(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push('(');
                if (stack.size() > 1) stringBuilder.append('(');
            } else {
                if (stack.size() > 1) stringBuilder.append(')');
                stack.pop();
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     * <p>
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 你能在线性时间复杂度内解决此题吗？
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * <p>
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * https://leetcode-cn.com/problems/sliding-window-maximum/
     *
     * @param nums
     * @param k
     * @return
     */
    // 1.大顶堆
    // 1.1 维护大顶堆，返回最大值
    // 2.双指针（同向双指针）
    // 2.1 遍历快指针
    // 2.2 维护慢指针：慢指针在移动到下一个元素比当前元素大的位置，返回满指针的值
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        //
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < nums.length; i++) {
            // 维护窗口
            if (i - k + 1 > 0) queue.remove(nums[i - k + 1]);
            queue.offer(nums[i]);
            if (queue.size() == k) result[i - k + 1] = queue.peek();
        }

        return result;
    }

    // 双指针
    // stack
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }




}
