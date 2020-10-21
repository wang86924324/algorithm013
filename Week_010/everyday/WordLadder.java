package Week_010.everyday;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

/**
 * https://leetcode-cn.com/problems/word-ladder/description/
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.isEmpty()) {
            return 0;
        }

        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return height;
                }

                for (int i = 0; i < wordList.size(); i++) {
                    if (visited[i] || !canConvert(cur, wordList.get(i))) {
                        continue;
                    }

                    visited[i] = true;
                    queue.add(wordList.get(i));
                }
            }
        }

        return 0;
    }

    private boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            count += s1.charAt(i) == s2.charAt(i) ? 0 : 1;
        }
        return count == 1;
    }


}
