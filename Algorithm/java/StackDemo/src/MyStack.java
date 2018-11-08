


public class MyStack<T> {
    Object data[];
    int top;
    int maxSize;



    public void initStack(int size){
        this.maxSize=size;
        this.data=new Object[maxSize];
        this.top=-1;
    }

    /**
     * 入栈
     * @param elem
     * @throws Exception
     */
    public void push(T elem) throws Exception {
        if(top==maxSize-1){
            throw new Exception("栈中已满");
        }
        top++;
        data[top]=elem;
    }

    /**
     * 出栈
     * @return
     * @throws Exception
     */
    public Object pop() throws Exception {
        if(top==-1){
            throw new Exception("栈以空");
        }
        Object obj=data[top];
        top--;
        return obj;
    }

    /**
     * 遍历
     */
    public void traverse (){
        for(int i=0;i<=top;i++){
            System.out.print(data[i]+"\t");
        }
    }
}
