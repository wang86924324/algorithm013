package homework.week7.everyday;

import java.lang.reflect.Array;
import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    /**
     * 解题思路：
     * 1.暴力排序 NlogN
     * 2.最小堆 NlogK
     * 3.桶排序 O(N)
     */

    //  1.hash统计 O(N)
    // 2. 循环放入大小为k小顶堆 2.1 小于k个元素的时候，直接放入  2.2 从k+1个元素开始，如果大于第k个元素（堆顶），需要剔除堆顶元素并且加入当前元素。
    // 3. 遍历小顶堆，放入数组  3.1 由于队列元素小于等于k，所以直接把队列元素放入数组即可。
//    public int[] topKFrequent(int[] nums, int k) {
//        // map计数
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
//
//        // 维护大小为k的小顶堆
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
//        for (int num : map.keySet()) {
//            if (priorityQueue.size() < k) {
//                priorityQueue.add(num);
//            } else if (map.get(num) > map.get(priorityQueue.peek())) {
//                priorityQueue.poll();
//                priorityQueue.add(num);
//            }
//        }
//        // 小于等于k个元素的队列转换为长度为k的数组中
//        int[] res = new int[k];
//        for (int j = 0; !priorityQueue.isEmpty(); j++) res[j] = priorityQueue.poll();
//        return res;
//    }


    // 桶排序  O(N)
    public int[] topKFrequent(int[] nums, int k) {
        // map计数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] buckets = new List[nums.length + 1];
        Arrays.fill(buckets, new ArrayList<Integer>());
        for (int key : map.keySet()) buckets[map.get(key)].add(key);


        int[] res = new int[k];
        // 从后向前遍历二维变长数组，找k个即可返回
        for (int i = buckets.length - 1; i >= 0; i--) for (int j = 0; j < buckets[i].size() && k >= 0; j++) {
            res[--k] = buckets[i].get(j);
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        new TopKFrequentElements().topKFrequent(nums, 2);
    }

}
