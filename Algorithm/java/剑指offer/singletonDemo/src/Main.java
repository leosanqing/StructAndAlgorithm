public class Main {
    public static void main(String[] args) {

        Person p = new Person("张三", 19);
        Person p2 = p;
        p2.setName("李四");
        System.out.println("p.toString() = " + p.toString());


        Integer i = 129;
        Integer i2 = i;
        i2+=1;
        System.out.println("i = " + i);

    }
}

