package homework.week4.everyday;

/**
 * https://leetcode-cn.com/problems/24-game/
 *
 * 679. 24 点游戏
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 示例 1:
 *
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 *
 * 输入: [1, 2, 1, 2]
 * 输出: False
 */
public class JudgePoint24 {
    public boolean judgePoint24(int[] nums) {
        return backTrack(nums, 0);
    }

    // 第一步：求出所有排列，一一验证
    public boolean backTrack(int[] nums, int index) {
        if (index == 4) {
            return judge(nums[0], nums[1], nums[2], nums[3]);
        }
        for (int i = index; i < 4; i++) {
            swap(nums, index, i);
            if (backTrack(nums, index + 1)) return true;
            swap(nums, index, i);
        }
        return false;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 第二步：由于已经全排列，a、b、c、d 都是等价的，利用四种运算符选出三个数继续
    public boolean judge(double a, double b, double c, double d) {
        return judge(a + b, c, d) ||
                judge(a - b, c, d) ||
                judge(a * b, c, d) ||
                judge(a / b, c, d);
    }

    // 第三步：a 是有两个数组成的，b、c 只表示一个数，等价
    public boolean judge(double a, double b, double c) {
        // 情况一：a 和 b(c) 组合，a 和 b(c) 不等价，- 号和 / 号需要考虑两种情况
        return judge(a + b, c) ||
                judge(a - b, c) ||
                judge(a * b, c) ||
                judge(a / b, c) ||
                judge(b - a, c) ||
                judge(b / a, c) ||
                // 情况二：b 和 c 组合
                judge(a, b - c) ||
                judge(a, b + c) ||
                judge(a, b * c) ||
                judge(a, b / c);
    }

    // 第四步：a 和 b 不等价
    public boolean judge(double a, double b) {
        return Math.abs(a + b - 24) < 0.001 ||
                Math.abs(a - b - 24) < 0.001 ||
                Math.abs(a * b - 24) < 0.001 ||
                Math.abs(a / b - 24) < 0.001 ||
                Math.abs(b - a - 24) < 0.001 ||
                Math.abs(b / a - 24) < 0.001;
    }
}
