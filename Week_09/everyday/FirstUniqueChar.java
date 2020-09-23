package Week_09.everyday;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueChar {

    public int firstUniqChar(String s) {
        int[] stat = new int[26];
        for (int i = 0; i < s.length(); i++) {
            stat[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (stat[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
