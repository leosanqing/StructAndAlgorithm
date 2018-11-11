public class Test {
    public static void main(String[] args) {
        String str1="adfabcdd";
        String str2="ababaaaba";
        KMPStringMatcher kmpStringMatcher=new KMPStringMatcher();




        for(int i:kmpStringMatcher.getNext(str2.toCharArray())){
            System.out.print(i+"\t");
        }
      //  System.out.println(kmpStringMatcher.getNext(str2.toCharArray()).toString());

        System.out.println();
        int index=kmpStringMatcher.indexOf(str1,str2);
        System.out.println(index);
    }
}
