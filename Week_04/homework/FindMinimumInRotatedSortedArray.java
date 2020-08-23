package homework.week4.homework;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */

/**
 * 1.暴力
 * 2.二分查找
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] <= nums[right]) return nums[left];

            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}
