import junit.framework.TestCase;

public class Test extends TestCase {
    public void testAdd() throws Exception {
        LinkedList<String> LinkedList=new LinkedList<String>();
        //测试在尾部新增数据
        for(int i=0;i<10;i++){
            LinkedList.add(String.valueOf(i));
        }
        // 遍历输出链表
        System.out.print("数据信息为:");
        LinkedList.traverse();


        //测试在指定位置插入数据
        LinkedList.add(3,"*");
        System.out.print("插入新的数据后:");
        LinkedList.traverse();

        //获取指定位置的数据
        String s = LinkedList.getElem(3);
        System.out.println("获取第3位置的数据是:"+s);

        //移除指定位置的数据
        LinkedList.delete(3);
        System.out.print("移除第3位置的数据后:");
        LinkedList.traverse();

        //更新指定位置数据后
        LinkedList.setElem(3,"333");
        System.out.print("更新指定位置数据后");
        LinkedList.traverse();



    }
}
