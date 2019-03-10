public class NetherlandFlag {

    public static void main(String[] args) {
        int[] arr = {0,0,1,2,1,2,1,2,0,2,1,2,0,1,2,0,0,2,1,0,2,1,0,2,1,0,2,1,1,2,0,2,1,2,1,0};
        partition(arr,0,arr.length-1,1);
        for(int num : arr){
            System.out.print(num+" ");
        }
        

    }
    
    public static void partition(int[] arr,int l,int r,int num){
        if(l > r)
            return;
        int before = l;
        int after = r ;
        int current = l;
        while (before < after){
            if (arr[current] < num){
                swap(arr,before,)
            }
        }
    }

}