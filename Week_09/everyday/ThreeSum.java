package Week_09.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * https://leetcode-cn.com/problems/3sum/
     * 1.先排序，外层循环去重，内层双指针（结果处while循环去重）
     * 2.返回三元组，是数字而不是索引。
     * 3.sum>0 right--;
     * @param nums
     * @return
     */
    // 排序 三指针去重
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[left++],nums[right--]));
                    while (left<right && nums[left]==nums[left-1]) left++;
                    while (left<right && right+1<nums.length && nums[right]==nums[right+1]) right--;
                }
                else if(sum>0) right--;
                else  left++;
            }
        }

        return res;
    }


}
