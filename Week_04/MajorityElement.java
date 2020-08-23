package homework.week4;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 分析：
 * 1.Map统计
 * 2.排序，去中间值
 * 3.分治
 */
public class MajorityElement {
//    public Integer majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        for (Integer key : map.keySet()) {
//            if (map.get(key) > nums.length / 2) return key;
//        }
//
//        return -1;
//    }

//    public Integer majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }

//    public int majorityElement(int[] nums) {
//        return majorityElementRec(nums, 0, nums.length - 1);
//    }
//
//    private int majorityElementRec(int[] nums, int start, int end) {
//        if (start == end) {
//            return nums[start];
//        }
//
//        int mid = (end - start) / 2;
//        int left = majorityElementRec(nums, start, mid);
//        int right = majorityElementRec(nums, mid + 1, end);
//
//        if (left == right) {
//            return left;
//        }
//
//    }

    // 投票法 多数个数-其他元素个数》=1
    // 假设第一个元素为了候选元素，遇到其他跟他相等的元素+1，否则-1，遇到为0的换届，及时前面有2x元素，其中x个众数，x非众数。后面还是会换回来的。
    public Integer majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += candidate == num ? 1 : -1;
        }

        return candidate;
    }
}
