# Java数据结构之HashMap
### 核心存储结构（数组+链表）


    int threshold;
     /**
      * The number of key-value mappings contained in this map.
      */
    transient int size;
    transient Node<K,V>[] table;
    static class Node<K,V> implements Map.Entry<K,V> {
                final int hash;
                final K key;
                V value;
                Node<K,V> next; }
    
### 核心方法
    public HashMap(int initialCapacity, float loadFactor) {
        // ....
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }
#### 扩容

#### put方法
    /**
     * Implements Map.put and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        // 如果map为空，则扩容
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        // 如果待插入位置元素p为null，直接插入进去即可。
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            // 如果元素p的key跟当前元素的key相等，那么把元素p赋值到变量e上，后面会做value的跟操作
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            // 如果P的类型是teeeNode，调用treeNode的添加值的方法。
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
            // P的类型是链表
                for (int binCount = 0; ; ++binCount) {
	                // 新增场景：配合下面的p=e，进行链表遍历，找不到跟当前元素相等的节点key，那么把当前元素放到p后面。
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        // 插入钱元素大于等于7的话，需要把链表转成红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // 修改场景：链表上找到节点的key，这个key跟带插入的key相等，那么终止遍历
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            // 用传入的变量更新e的value值
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

#### get方法
	final Node<K,V> getNode(int hash, Object key) {  
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;  
		if ((tab = table) != null && (n = tab.length) > 0 &&(first = tab[(n - 1) & hash]) != null) {  
		// 如果hash桶的第一个元素key跟待查找的key相等，直接返回（先比较hash是为了加速）。
        if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k))))  
            return first;  
        
		if ((e = first.next) != null) {  
			// 红黑树查找
			if (first instanceof TreeNode)  return ((TreeNode<K,V>)first).getTreeNode(hash, key);  
			do {  
				// 链表遍历查找
				if (e.hash == hash &&  ((k = e.key) == key || (key != null && key.equals(k)))) return e;  
				} while ((e = e.next) != null);  
			}  
		}  
		return null;  
	}

    

