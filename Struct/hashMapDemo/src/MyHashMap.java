public class MyHashMap {

    // 初始默认的
    static final int INIT_CAPACITY = 1<<4;
    static final int MAX_CAPATITY = 1<<30;
    static final float DEFAULT_LOADFACTOR = 0.75f;



    static class Entry<K,V>{
        private K key;
        private V value;
        private Entry<K,V> next;
        private int h;

        public Entry(K key, V value, Entry next, int h) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.h = h;
        }

        public Entry() {

        }

        public Object getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }
    }
}
