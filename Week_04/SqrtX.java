package homework.week4;

public class SqrtX {
    // 遍历
//    public int mySqrt(int x) {
//        int i = 0;
//        while ((long)i * i <= x) {
//            i++;
//        }
//
//        return (int)i - 1;
//    }



    public int mySqrt(int x) {
        int left = 0, right = x, res = -1;
        // 相邻的时候中间值是left
        // 如果此时比x小，那么left=right，需要做一次判断
        // 如果此时比x大，那么right=left-1，是因为left从mid位置移动过来了，返回mid即可
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }

        return res;
    }


}
