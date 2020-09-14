package homework.week7.everyday;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/word-ladder/description/
 */
public class WordLadder {
    // BFS
    // 下一层元素特征：1.这个元素之前没有访问过 2.这个元素跟当前元素只有一个字母只差
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) return 0;

        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            while (size-- > 0) {
                String cur = queue.poll();
                if (endWord.equals(cur)) return height;

                for (int i = 0; i < wordList.size(); i++) {
                    if (visited[i] || !canConvert(wordList.get(i), cur)) continue;
                    visited[i] = true;
                    queue.add(wordList.get(i));
                }
            }
        }
        return -1;
    }

    private boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); i++) count += s1.charAt(i) != s2.charAt(i) ? 1 : 0;
        return count == 1;
    }


}
