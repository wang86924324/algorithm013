package homework.week6;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 1.暴力法  O(N)
 * 2.二分法 部分有序  O(logN)
 * 假设翻转数组位置K [0,1...k,k+1,n-1],{0,k-1}]有序，并且大于{k,n-1}
 * mid如果在[0,k-1]之间，target进行比较，如果target在[nums[left],nums[mid])，可以继续二分。
 * mid如果在[k,n-1]之间，如果target在(nums[mid],nums[right]]之间也可以继续二分
 * 总结：二分的前提是数组有序，只要找到一个区间有序就可以用二分，本题目就是半边有序
 */
public class SearchInRotatedRortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            // mid在左边
            if (nums[left] <= nums[mid]) {
                // [left,mid)有序
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            // mid 在右边
            else {
                // (mid,right]之间有序
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
