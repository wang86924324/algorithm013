package Week_08.homework;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/lru-cache/#/
 * <p>
 * 数据结构： 1.Map 2.linkedList
 */
public class LRUCache {

    HashMap<Integer, Integer> map;
    LinkedList<Integer> keys;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        keys = new LinkedList<>();
        this.capacity = capacity;
    }

    /**
     * 添加元素
     * 1.元素存在，放到队尾
     * 2.不存在，判断链表是否满。
     * 如果满，则删除队首元素，放入队尾元素，删除更新哈希表
     * 如果不满，放入队尾元素，更新哈希表
     */
    public void put(Integer key, Integer value) {
        Integer v = map.get(key);
        if (v != null) {
            keys.remove(key);
            keys.addLast(key);
            map.put(key, value);
            return;
        }

        //队列未满，添加到尾部
        if (keys.size() < capacity) {
            keys.addLast(key);
            map.put(key, value);
        } else {
            //队列已满，移除队首
            Integer firstKey = keys.removeFirst();
            map.remove(firstKey);
            keys.addLast(key);
            map.put(key, value);
        }
    }

    /**
     * 访问元素
     * 元素存在，放到队尾
     */
    public Integer get(Integer key) {
        Integer v = map.get(key);
        if (v != null) {
            keys.remove(key);
            keys.addLast(key);
            return v;
        }
        return -1;
    }

}
