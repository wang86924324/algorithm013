package homework.week4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/assign-cookies/description/
 * 455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 注意：
 * <p>
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3], [1,1]
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * <p>
 * 输入: [1,2], [1,2,3]
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * <p>
 * 分析：
 * 1.贪心算法 两个数组从大到小排序，利用双指针优先给胃口大的使用分配尺寸大的 O(Nk)
 * 2.递归去最大值
 */
public class AssignCookies {
//    int max = 0;
//
//    public int findContentChildren(int[] g, int[] s) {
//        int level = 0;
//        int count = 0;
//        boolean[] visited = new boolean[s.length];
//        dfs(g, s, level, count, visited);
//        return max;
//    }
//
//    private void dfs(int[] g, int[] s, int level, int count, boolean[] visited) {
//        if (level == g.length || level == s.length) {
//            max = Math.max(max, count);
//            return;
//        }
//
//        for (int i = 0; i < s.length; i++) {
//            if (visited[i]) continue;
//            visited[i] = true;
//            count += g[level] <= s[i] ? 1 : 0;
//            dfs(g, s, level + 1, count, visited);
//            count -= g[level] <= s[i] ? 1 : 0;
//            visited[i] = false;
//        }
//
//    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }

        return i;
    }

}
