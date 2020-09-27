package Week_09.everyday;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueChar {

//    public int firstUniqChar(String s) {
//        int[] stat = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            stat[s.charAt(i) - 'a']++;
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            if (stat[s.charAt(i) - 'a'] == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int firstUniqChar(String s) {
        // 数组下表记录
        int[] counter = new int[26];
        for (char ch : s.toCharArray()) {
            counter[ch - 'a']++;
        }

        // 遍历字符串中的字符找到第一个统计数为1的数字返回即可
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
