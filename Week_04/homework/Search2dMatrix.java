package homework.week4.homework;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */

/**
 * 1. 暴力 O(M*N)
 * 2.二分查找
 */
public class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int[] cur = matrix[mid];
            if (cur[0] <= target && target <= cur[n - 1]) {
                int l = 0, r = n - 1;
                while (l <= r) {
                    int middle = l + (r - l) / 2;
                    if (cur[middle] == target) return true;
                    if (cur[middle] > target) r = middle - 1;
                    else l = middle + 1;
                }
                return false;
            }

            if (target < matrix[mid][0]) right = mid - 1;
            if (target > matrix[mid][n - 1]) left = mid + 1;
        }

        return false;
    }
}
