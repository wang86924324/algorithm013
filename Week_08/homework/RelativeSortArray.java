package Week_08.homework;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 */
public class RelativeSortArray {

    // 计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int num : arr1) {
            count[num]++;
        }

        int i = 0;
        for (int num2 : arr2) {
            while (count[num2] > 0) {
                arr1[i++] = num2;
                count[num2]--;
            }
        }

        for (int num1 = 0; num1 < count.length; num1++) {
            while (count[num1] > 0) {
                arr1[i++]=num1;
                count[num1]--;
            }
        }

        return arr1;
    }





}
