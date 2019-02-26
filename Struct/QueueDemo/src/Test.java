public class Test {
    public static void main(String[] args) throws Exception {
        Queue<Object> queue=new Queue<>();
        System.out.println(queue.isEmpty());

        queue.init(6);
        for (int i=0;i<queue.getMaxSize()-1;i++){
            queue.enQueue(i);
        }
        System.out.println(queue.length());

        //queue.enQueue(90);
        int length=queue.length();
        for(int i=0;i<queue.getData().length;i++)
            System.out.println(queue.getData()[i]);
    }
}
