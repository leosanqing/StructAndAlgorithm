/**
 * 循环队列
 * @param <T>
 */


public class Queue<T> {
    private int front;
    private int tail;
   private T data[];
    private int maxSize;
    private int size;


    /**
     * 初始化队列
     * @param maxSize
     */

    public void init(int maxSize){
        front =0;
        tail=front;
        data=(T[])new Object[maxSize];
        this.maxSize=maxSize;
        this.size=0;

    }

    /**
     * 队列大小
     * @return
     */
    public int length(){
        return (tail-front+maxSize)%maxSize;
    }

    /**
     * 入队
     */
    public void enQueue(T elem) throws Exception {
        if((tail+1)%maxSize==front){
            throw new Exception("队列已满");
        }

        data[tail]=elem;
        tail=(tail+1)%maxSize;
        ++size;
    }

    /**
     * 出队
     * @return
     * @throws Exception
     */

    public T DeQueue() throws Exception {
        if(front==tail)
            throw new Exception("队列已空");
        T elem=data[front];
        front=(front+1)%maxSize;
        size--;
        return elem;
    }

    public void clear(){
        front=0;
        tail=front;
        System.gc();

    }

    public boolean isEmpty(){
        return front==tail;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }
}
