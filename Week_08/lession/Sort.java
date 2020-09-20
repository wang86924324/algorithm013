package Week_08.lession;

import java.util.PriorityQueue;

/**
 * https://www.cnblogs.com/onepixel/p/7674659.html
 * https://shimo.im/docs/TX9bDbSC7C0CR5XO/read
 * https://shimo.im/docs/sDXxjjiKf3gLVVAU/read
 * https://shimo.im/docs/M2xfacKvwzAykhz6/read
 */
public class Sort {

    // 假设调用一个方法能把数组分成量部分，返回一个位置，这个位置的左边所有元素小于这个位置的元素，右边所有元素大于这个位置的元素。
    // 那么快速排序本质上递归排序，代码模板类似二分查找。
    public static void quickSort(int[] array, int begin, int end) {
        // teminate
        if (end <= begin) {
            return;
        }
        int mid = partition(array, begin, end);
        quickSort(array, begin, mid - 1);
        quickSort(array, mid + 1, end);
    }

    // 快慢指针：慢指针左边是比pivot小的元素，跟移动零问题类似。
    private static int partition(int[] a, int begin, int end) {
        int pivot = end, count = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[count];
                a[count] = a[i];
                a[i] = temp;
                count++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[count];
        a[count] = temp;
        return count;
    }


    // 自顶向下二分、自底向上merge。
    // 归并排序=二叉树后续遍历模板+合并两个子序列模板
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        // 合并两个子序列
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        while (i <= mid) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];
        for (int p = 0; p < temp.length; p++) array[left + p] = temp[p];
    }


    public static void heapSort(int[] array) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int i=0;i<array.length;i++) priorityQueue.add(array[i]);

        for(int i=0;i<array.length;i++) array[i]=priorityQueue.poll();
    }
}
