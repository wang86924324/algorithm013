package homework.week4;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: rg
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */

/**
 *  输入: [3,2,1,0,0,1,4]
 *
 * 贪心算法：遍历每个元素计算每个元素最远距离，
 */
public class JumpGame {

    // 遍历每个元素，计算最远达到的距离，判断能否达到最后位置即可,如果发现到不了中间某个位置，那么就说明到不了最后的位置
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) return true;
        }
        return false;
    }
}
