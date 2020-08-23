package homework.week4.everyday;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {
    // 1.排序 NlogN
    // 2. NlogK
    // 3.快速选择
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (arr.length <= k) {
//            return arr;
//        }
//
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        for (int num : arr) heap.add(num);
//
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) res[i] = heap.poll();
//        return res;
//    }

    class Solution {
        // 最好的情况，假设有序，就是二分查找
        // 平均情况：主定理 O(N)
        // 最坏的情况
        public int[] getLeastNumbers(int[] arr, int k) {
            //这里直接传k-1了
            quickselect(arr, 0, arr.length - 1, k - 1);
            return Arrays.copyOfRange(arr, 0, k);
        }

        private void quickselect(int[] nums, int start, int end, int k) {
            if (start == end) return;
            int pivot = nums[start];
            int i = start, j = end;
            // 双指针partition，可以理解为找到二分查找的mid，其中j=mid-1,i=mid+1
            while (i <= j) {
                while (i <= j && nums[i] < pivot) i++;
                while (i <= j && nums[j] > pivot) j--;
                if (i <= j) swap(nums, i++, j--);
            }
            // 二分递归
            if (k <= j) quickselect(nums, start, j, k);
            if (k >= i) quickselect(nums, i, end, k);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


//        private void quickselect(int[] nums, int start, int end, int k) {
//            if (start == end) return ;
//            int pivot = nums[start];
//            int i = start, j = end;
//            //遍历整个数组
//            while (i <= j) {
//                while (i <= j && nums[i] < pivot) i++;
//                while (i <= j && nums[j] > pivot) j--;
//                if (i <= j) {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                    i++;
//                    j--;
//                }
//            }
//            if (start <= k && k <= j) {
//                quickselect(nums, start, j, k);
//            } else if (i <= k && k <= end) {
//                quickselect(nums, i, end, k);
//            }
//        }
    }

}
