package homework.week6.monday;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * <p>
 * <p>
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
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * <p>
 * 1.思路利用二分查找，可以达到O(N)
 * 2.每次遍历的元素是上次的二分之一，所以总的时间复杂度不会超过n，但是接近n
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        quickSelect(nums, start, end, k);
        return Arrays.copyOfRange(nums, 0, k);
    }

    private void quickSelect(int[] nums, int start, int end, int k) {
        // partition
        int pivot = nums[start];
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) left++;
            while (left <= right && nums[right] > pivot) right--;
            swap(nums, left, right);
        }

        // k在左边
        if (k <= right) quickSelect(nums, start, right, k);
        if (k >= left) quickSelect(nums, left, end, k);
    }

//    private void quickSelect(int[] nums, int start, int end, int k) {
//        if (start == end) return;
//        int pivot = nums[start];
//        int i = start, j = end;
//        while (i <= j) {
//            while (i <= j && nums[i] < pivot) i++;
//            while (i <= j && nums[j] > pivot) j--;
//            if (i <= j) swap(nums, i, j);
//        }
//
//        // 二分递归，只会走一遍。
//        if (k <= j) quickSelect(nums, start, j, k);
//        if (k >= i) quickSelect(nums, i, end, k);
//
//    }

//    private void quickSelect(int[] nums, int start, int end, int k) {
//        if (start == end) return;
//
//        // partition
//        int pivot = nums[start];
//        int i = start, j = end;
//        while (i <= j) {
//            while (i <= j && nums[i] < pivot) i++;
//            while (i <= j && nums[j] > pivot) j++;
//            if (i <= j) swap(nums, i, j);
//        }
//
//        if (k <= j) quickSelect(nums, start, j, k);
//        if (k >= i) quickSelect(nums, i, end, k);
//
//    }


    private void swap(int[] nums, int i, int j) {

    }
}
