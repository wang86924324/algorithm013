package Week_011;

import java.util.LinkedList;
import java.util.Queue;

public class TrappingRainWater {

    public int trap(int[] height) {
        int min = 0, max = 0;
        int l = 0, r = height.length - 1;

        int res = 0;
        int i = 0;
        while (l < r) {
            System.out.println("l:" + l + ",r:" + r);
            min = height[height[l] < height[r] ? l++ : r--];
            max = Math.max(min, max);
            res += max - min;
            System.out.println("min:" + min +",max:" + max +  ",res:" + res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 2};
        new TrappingRainWater().trap(height);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.offer(3);
        queue.poll();
        queue.remove();
        queue.peek();

        System.out.println(queue.isEmpty());
    }


}
