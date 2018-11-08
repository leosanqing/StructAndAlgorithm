public class Test {
    public static void main(String[] args) throws Exception {
        MyStack myStack=new MyStack();
        myStack.initStack(5);
        for(int i=0;i<5;i++){
            myStack.push(i);
        }

        myStack.traverse();
        System.out.println();
        int size=myStack.top;
        for(int i=0;i<=size;i++){
            System.out.println(myStack.pop());
        }
    }
}
