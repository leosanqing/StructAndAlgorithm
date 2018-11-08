public class Main {



    public static void main(String[] args) throws Exception {
        MyList myList=new MyList();

        myList.initList(40);
        for (int i=0;i<20;i++){
            myList.data[i]=i;
            myList.length++;
        }



        System.out.println(myList.getElem(1));
        myList.insert(21,21);
        System.out.println(myList.getElem(21)+"===="+myList.length);

        myList.del(21);
        System.out.println(myList.getElem(21)+"===="+myList.length);
    }




}
