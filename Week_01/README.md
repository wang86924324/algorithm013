学习笔记
# Java数据结构之PriorityQueue
## 接口及父类分析

    public class PriorityQueue<E> extends AbstractQueue<E>
    public abstract class AbstractQueue<E>  extends AbstractCollection<E>  implements Queue<E>

### Queue接口

    public interface Queue<E> extends Collection<E>
    // 增加元素
    boolean add(E e);
    boolean offer(E e);
    // 删除元素
    E remove();
    E poll();
    // 获取元素
    E element();
    E peek();

- 两种实现的区别是，`add`、`remove`和`element`都比对应的`offer`、`poll`和`peek`多抛出一个异常。

### AbstractQueue

    public abstract class AbstractQueue<E>
        extends AbstractCollection<E>
        implements Queue<E>
        
    public boolean add(E e) {
            if (offer(e)) // 调用offer
            ...
        }
        
    public E remove() {
            E x = poll(); // 调用poll
            ...
        }
        
    public E element() {
            E x = peek(); // 调用peek
            ...
        }
- 模板类：add/remove/element依赖offer/poll/peek来实现，完成接口的约束。后续的实现类只需要实现offer/poll/peek接口。

## PriorityQueue源码分析

### 重要属性

    // 默认容量11
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    // 堆的存储结构，存储元素
    transient Object[] queue; // 不可序列化
    // 当前存储的元素数量
    int size;
    // 比较器，确定优先级高低
    private final Comparator<? super E> comparator;
    // 避免OOM，数组可以分配的最大容量
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

### 初始化
    public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }
### 扩容

    private void grow(int minCapacity) {  
        int oldCapacity = queue.length;  
      // Double size if small; else grow by 50%  
      int newCapacity = oldCapacity + ((oldCapacity < 64) ?  
                                         (oldCapacity + 2) :  
                                         (oldCapacity >> 1));  
      // overflow-conscious code  处理溢出一般可忽略
      if (newCapacity - MAX_ARRAY_SIZE > 0)  
            newCapacity = hugeCapacity(minCapacity);  
      queue = Arrays.copyOf(queue, newCapacity);  
    }

### offer方法

    public boolean offer(E e) {
            if (e == null)
                throw new NullPointerException();
            modCount++;
            int i = size;
            if (i >= queue.length)
                grow(i + 1); // 如果超出当前容量，则进行扩容
            siftUp(i, e); // 新元素都是增加在数组尾部，然后进行上移操作，即构建堆
            size = i + 1; // 当前大小加1
            return true;
        }

    private void siftUpUsingComparator(int k, E x) {  
        while (k > 0) {  
	        // Priority queue represented as a balanced binary heap: the two children of queue[n] are queue[2*n+1] and queue[2*(n+1)].
	        // 相当于(k-1)/2, 0,1,2分别为根、左和右节点的索引，那么k=1或2，那么parent都为0
	        // 假设是小顶堆，如果父节点比新增节点x小，需要把父节点移动到当前节点，知道遇到一个比当前节点大的元素，shiftup停止
			int parent = (k - 1) >>> 1;  
	        Object e = queue[parent];  
	        if (comparator.compare(x, (E) e) >= 0)  
                break;  
	         queue[k] = e;  
	         k = parent;  
         }  
        queue[k] = x;  
    }
    
### Poll方法
    public E poll() {
            final Object[] es;
            final E result;
            // 返回堆顶元素
            if ((result = (E) ((es = queue)[0])) != null) {
                modCount++;
                final int n;
                final E x = (E) es[(n = --size)]; // 把尾部元素换到第一个
                es[n] = null;
                if (n > 0) {
                    final Comparator<? super E> cmp;
                    if ((cmp = comparator) == null) // 自然序时，下移调整
                        siftDownComparable(0, x, es, n);
                    else // 自定义序下移调整
                        siftDownUsingComparator(0, x, es, n, cmp);
                }
            }
            return result;
        }
    
    private static <T> void siftDownUsingComparator(
            int k, T x, Object[] es, int n, Comparator<? super T> cmp) {
            // assert n > 0;
            int half = n >>> 1; // 最后一个非叶子结点下标（因为size已经减1了）
            while (k < half) {
                int child = (k << 1) + 1; // 左孩子
                Object c = es[child];
                int right = child + 1; // 右孩子
                if (right < n && cmp.compare((T) c, (T) es[right]) > 0)
                    c = es[child = right]; // 从左右孩子中挑选优先级高的
                if (cmp.compare(x, (T) c) <= 0)
                    break;
                es[k] = c; // 将目标元素下移
                k = child;
            }
            es[k] = x;
        }

  

