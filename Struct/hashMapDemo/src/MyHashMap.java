import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MyHashMap {

    // 初始默认的数组容量
    static final int INIT_CAPACITY = 1<<4;
    //数组最大的容量,因为 数组设置为 2的整次方倍，而 31 次方为负数，所以最大只能为 1 << 30
    static final int MAX_CAPACITY = 1<<30;
    // 默认的装填因子
    static final float DEFAULT_LOADFACTOR = 0.75f;


    /**
     * 定义 Entry类
     * @param <K>
     * @param <V>
     */
    static class Entry<K,V>{
         K key;
        private V value;
        private Entry<K,V> next;
        int h;

        public Entry(K key, V value, Entry next, int h) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.h = h;
        }

        public Entry() {

        }

        public K getKey() {
            return key;
        }


        public V getValue() {
            return value;
        }

        public V setValue(V newValue) {
            V oldValue=value;
            this.value = newValue;
            return oldValue;

        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }

        public  final int hashcode(){
            return Objects.hashCode(key)^Objects.hashCode(value);
        }

    }


    // 返回 hash值 ，如果 key 为 null，返回 0
    static final int hash(Object key){
        int h;
        return (key==null) ? 0 : (h=key.hashCode())^(h >>> 16);
    }


    // 数组长度，通过这个运算得到
    // 扩容后的大小总是 2的 n 次方倍，且是离未扩容前的数字最近的那个 2的n次方
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
    }



    Entry[] table;

    // table size;
    int size;


    // 修改次数
    int modCount;

    // 扩容的阈值, capacity * load factor
    int threshold;

    // 装填因子
    float loadFactor;

    public MyHashMap(int initCapacity,float loadFactor) {
        if(initCapacity<0)
            throw new IllegalArgumentException("初始化容量失败: "+
                                                    initCapacity);
        if(initCapacity>= MAX_CAPACITY)
            initCapacity= MAX_CAPACITY;
        if(loadFactor<=0||Float.isNaN(loadFactor))
            throw new IllegalArgumentException("装填因子不合法"+
                                                    loadFactor);
        this.loadFactor=loadFactor;
        this.threshold=tableSizeFor(initCapacity);

    }

    /**
     * 只传入数组容量大小的
     * @param initCapacity
     */
    public MyHashMap(int initCapacity) {
        this(initCapacity,DEFAULT_LOADFACTOR);
    }

    /**
     * 无参的，全部默认
     */
    public MyHashMap() {
        this.loadFactor=DEFAULT_LOADFACTOR;
    }


    public MyHashMap(Map m){
        this.loadFactor=DEFAULT_LOADFACTOR;

    }

    final void putEntries(Map m,boolean evict){
        int s=m.size();
        if(s>0){
            if(table==null){
                float ft=(float) s/loadFactor+1.0f;

                int t=(ft<(float) MAX_CAPACITY)?(int)ft: MAX_CAPACITY;

                // 如果 原来的 hashmap的 table 的大小为0（第一次添加数字）；
                // 那么就将他按照现在的 添加的table 大小进行扩容
                if(t>threshold){
                    threshold=tableSizeFor(t);
                }


            }
            // 如果添加的 entries 的 table 大小大于 阈值，就扩容
            else if(s>threshold){
                resize();
            }

            // 把各个 Entry 放入到 map中
            for( Object e :  m.entrySet()){

                Object key = ((Map.Entry) e).getKey();
                Object value = ((Map.Entry) e).getValue();
                //putVal();
            }
        }
    }

    /**
     *
     * @return
     */
    final  Entry[] resize() {
        // 定义旧的数组为 Entry 类型的数组，oldTab
        Entry[] oldTab = table;
        // 如果oldTab==null  则返回 0，否则返回数组大小
        int oldCap = (oldTab==null) ? 0 : oldTab.length;

        int oldThreshold = threshold;

        int newCap=0,newThreshold=0;

        // 说明已经不是第一次 扩容，那么已经初始化过，容量一定是 2的n次方，所以可以直接位运算
        if(oldCap>0){
            // 如果 原来的数组大小已经大于等于了最大值，那么阈值设置为 Integer的最大值,即不会再进行扩容
            if(oldCap >= MAX_CAPACITY){
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }

            // 因此已经不是第一次扩容，一定是2的n次方
            else if ((newCap = oldCap << 1) < MAX_CAPACITY &&
                      oldCap >= INIT_CAPACITY)

                newThreshold = oldThreshold << 1;

        }
        // 如果oldThreshold > 0,并且oldCap == 0，说明是还没有进行调用resize方法。
        // 说明输入了初始值，且oldThreshold为 比输入值大的最小的2的n次方
        // 那么就把 oldThreshold 的值赋给 newCap ，因为这个值现在为 比输入值大的最小的2的n次方
        else if(oldThreshold>0)
            newCap = oldThreshold;

        // 这个条件是 第一次扩容，且 oldThreshold == 0，即输入的initialCap == 0；
        else{
            newCap = INIT_CAPACITY;
            newThreshold = (int) (INIT_CAPACITY * DEFAULT_LOADFACTOR);
        }

        if(newThreshold == 0){

            float ft = (float) (newCap * loadFactor);
            newThreshold =(newCap < MAX_CAPACITY && ft < (float) MAX_CAPACITY ?
                    (int )ft : Integer.MAX_VALUE);
        }

        threshold = newThreshold;

        Entry newTable[] = new Entry[newCap];
        table=newTable;

        // 将原来数组中的所有元素都 copy进新的数组
        if(oldTab != null){
            for (int j = 0; j < oldCap; j++) {
                Entry e;

                if((e = oldTab[j]) != null){
                    oldTab[j] = null;

                    // 说明还没有成链，数组上只有一个
                    if(e.next == null){
                        // 重新计算 数组索引 值
                        newTable[e.h & (newCap-1)] = e;

                    }
                    // 判断是否为树结构
                    //else if (e instanceof TreeNode)


                    // 如果不是树，只是链表
                    else{
                        Entry loHead=null, loTail =null;
                        Entry hiHead = null, hiTail = null;
                        Entry next;
                        do {
                            next = e.next;

                        }

                    }
                }

            }
        }

        return null;
    }





}
