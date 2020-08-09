package Week_02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeWork {
    // https://leetcode-cn.com/problems/valid-anagram/description/
    // 1.先排序，再比较 时间复杂度O(N)
    // 2.hashMap统计  时间复杂度：O(N) 空间复杂度:O(N)
    // 3.26长度数组基数，一个指针遍历两个数组，一个记录整数，一个记录负数。
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
    }

    // 1.暴力  O(N^2)
    // 2.排序+双指针夹逼  O(nLogn)
    // 3.hashMap计数
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 1) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return new int[]{map.get(nums[i]),i};
            map.put(target - nums[i], i);
        }
        return new int[0];
    }


}
