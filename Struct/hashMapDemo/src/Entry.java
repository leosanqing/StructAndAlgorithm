import java.util.HashMap;

public class Entry {
    private Object key;
    private Object value;
    private Entry next;
    private int h;

    public Entry(Object key, Object value, Entry next, int h) {
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

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
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
