public class LinkedList<T> {
    private Node head;
    private Node tail;
    private Node p;
    private int length;


    private class Node{
        private T data;
        private Node next;

        public Node() {
            data=null;
        }

        public Node(T data, Node next) {

            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this.data = data;
        }
    }

    public LinkedList(){
        head=new Node();
        tail=head;
        length=0;
    }

    //在尾部添加节点
    public void add(T obj){
        p=new Node(obj);
        tail.next=p;
        tail=p;
        length++;
    }

    public void add(int index,T obj) throws Exception {
        if(index>length)
            throw new Exception("超出范围");

        moveToIndex(index);

        Node q=new Node(obj);
        q.next=p.next;
        p.next=q;

    }

    /**
     * 将指针移动到该索引的前一个节点
     * @param index
     */
    private void moveToIndex(int index) {
        p=head;
        while(p.next!=null){
            if(index==0){
                break;
            }

            p=p.next;
            index--;
        }

    }

    public void clear(){
        head=null;
        length=0;
        tail=head;
        System.gc();
    }

    /**
     * 删除指定索引的节点，并返回删除节点的值
     * @param index
     * @return
     */
    public T delete(int index){
        moveToIndex(index);
        T data=p.next.data;
        p.next=p.next.next;
        return data;
    }

    /**
     * 获取该节点的值
     * @param index
     * @return
     */
    public T getElem(int index){
        moveToIndex(index);
        return p.next.data;
    }

    public void setElem(int index,T obj){
        moveToIndex(index);
        p.next.data=obj;
    }

    public void traverse(){
        p=head;
        if(p!=null){
            while(p.next!=null){
                System.out.print(p.next.data+"\t");
                p=p.next;
            }
        }

        System.out.println();
    }





}



















