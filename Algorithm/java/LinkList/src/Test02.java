public class Test02 {

    public static void main(String[] args) throws Exception {
        LinkedList linkedList=new LinkedList();
        for (int i=0;i<20;i++){
            linkedList.add(i);
        }
        linkedList.traverse();
        //测试在指定位置插入数据
        linkedList.add(3,"*");
        System.out.print("插入新的数据后:");
        linkedList.traverse();

        //获取指定位置的数据
        Object s = linkedList.getElem(3);
        System.out.println("获取第3位置的数据是:"+s);

        //移除指定位置的数据
        linkedList.delete(3);
        System.out.print("移除第3位置的数据后:");
        linkedList.traverse();

        //更新指定位置数据后
        linkedList.setElem(3,"333");
        System.out.print("更新指定位置数据后");
        linkedList.traverse();
    }
}
