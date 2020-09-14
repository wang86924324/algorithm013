package homework.week7.everyday;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class Search2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m * n - 1;
        while (left <= right) {
            int midIndex = (left + right) / 2;
            int mid = matrix[midIndex / n][midIndex % n];
            if (target == mid) return true;
            if (target > mid) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
