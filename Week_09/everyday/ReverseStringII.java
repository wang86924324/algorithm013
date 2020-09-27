package Week_09.everyday;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class ReverseStringII {

//    public String reverseStr(String s, int k) {
//        char[] ch = s.toCharArray();
//        int n = ch.length;
//        for (int i = 0; i < n; i += 2 * k) {
//            int left = i;
//            int right = (i + k - 1 < n) ? i + k - 1 : n - 1;
//            while (left <= right) {
//                char temp = ch[left];
//                ch[left]=ch[right];
//                ch[right]=temp;
//                left++;
//                right--;
//            }
//        }
//
//        return new String(ch);
//    }

    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;

        // 循环一段一段处理
        for (int i = 0; i < n; i += 2 * k) {
            //i ...i+2k之间前k个元素reverse，使用双指针
            for(int left = i, right = i + k - 1 < n ? i + k - 1 : n - 1;left<=right;left++,right--){
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
            }
        }

        return new String((ch));
    }


}
