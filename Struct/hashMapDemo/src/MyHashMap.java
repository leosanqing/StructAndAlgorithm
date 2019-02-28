import java.util.Map;
import java.util.Objects;

public class MyHashMap {

    // 初始默认的数组容量
    static final int INIT_CAPACITY = 1<<4;
    //数组最大的容量
    static final int MAX_CAPATITY = 1<<30;
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
        return (n < 0) ? 1 : (n >= MAX_CAPATITY) ? MAX_CAPATITY : n + 1;
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
        if(initCapacity>=MAX_CAPATITY)
            initCapacity=MAX_CAPATITY;
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

                int t=(ft<(float)MAX_CAPATITY)?(int)ft:MAX_CAPATITY;

                if(t>threshold){
                    threshold=tableSizeFor(t);
                }

            }else if(s>threshold){
                resize();
            }
        }
    }

    /**
     *
     * @return
     */
    final  Entry[] resize() {
        Entry[] oldTab=table;
        int

    }
}
