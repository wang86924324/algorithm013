package homework.week4.homework;

import homework.week4.ListNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/description/
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */

/**
 * 1.BFS
 */
public class WordLadder {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (!wordList.contains(endWord)) return 0;
//
//        Set<String> visited = new HashSet<>();
//        Queue<String> queue = new LinkedList<>();
//        queue.add(beginWord);
//        visited.add(beginWord);
//        int count = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            count++;
//
//            while (size-- > 0) {
//                String start = queue.poll();
//                for (String s : wordList) {
//                    // 剪枝
//                    if (visited.contains(s) || !canConvert(start, s)) continue;
//
//                    // 递归终止
//                    if (s.equals(endWord)) return count + 1;
//
//                    visited.add(s);
//                    queue.add(s);
//                }
//
//            }
//        }
//
//        return 0;
//    }
//
//    private boolean canConvert(String s1, String s2) {
//        if (s1.length() != s2.length()) return false;
//
//        int count = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            count += s1.charAt(i) != s2.charAt(i) ? 1 : 0;
//        }
//
//        return count == 1;
//    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++count;
            while (size-- > 0) {
                String start = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    String s = wordList.get(i);
                    // cut leaf
                    if (visited[i] || !canConvert(start, s)) continue;

                    // 终止条件
                    if (s.equals(endWord)) return count + 1;

                    // 加入队列
                    visited[i] = true;
                    queue.add(s);
                }
            }
        }

        return 0;
    }

    private boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); i++) count += s1.charAt(i) != s2.charAt(i) ? 1 : 0;
        return count == 1;
    }
}
