import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("name","张三");

        Object oldValue1 = hashMap.put("name","李四");
        Object oldValue2 = hashMap.put("age",18);
        System.out.println("oldValue = " + oldValue1);
        System.out.println("oldValue2 = " + oldValue2);
    }
}
