public class ViolentMatch implements StringMatcher{

    @Override
    public int indexOf(String str1, String str2) {
        int i=0,j=0;
        int len1=str1.length(),len2=str2.length();
        char[] char1=str1.toCharArray();
        char[] char2=str2.toCharArray();

        while(i<len1&&j<len2){
            if(char1[i]==char2[j]){
                ++i;
                ++j;

            }else {
                i = i - j + 1;
                j = 0;

            }
        }
        if(j==len2)
            return i-j;
        else
            return -1;
    }

    public static void main(String[] args) {

        String str1="bbabcdef";
        String str2="babcd";
        ViolentMatch violentMatch=new ViolentMatch();
        System.out.println(violentMatch.indexOf(str1,str2));

    }
}
