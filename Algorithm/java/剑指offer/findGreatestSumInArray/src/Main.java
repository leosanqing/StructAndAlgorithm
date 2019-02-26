/**
 * 题目：求数组的连续最大和
 * 思路：如果当前指到的数字加上原来的之后还比现在的数字小，那么舍去之前
 *
 */
public class Main {
    public static void main(String[] args) {

        int nums[]={1,5,-4,-2,5,7,8,3,-1,5};
        System.out.println(findGreatestSumInArray(nums));


        System.out.println(CountOne2(11));
    }


    public static int findGreatestSumInArray(int [] nums){
        if (nums == null) {
            return -1;
        }

        //当前和
        int curSum=0;
        //最大和
        int greatestSum=0;
        for (int i = 0; i < nums.length; i++) {
            if(curSum<=0){
                curSum=nums[i];
            }else {
                curSum+=nums[i];
            }
            if(curSum>=greatestSum)
                greatestSum=curSum;
        }
        return greatestSum;
    }

    public static long CountOne2(long n) {
        long count = 0; // 1的个数
        long i = 1;  // 当前位
        long current = 0,after = 0,before = 0;

        while((n / i) != 0) {
            before = n / (i * 10); // 高位
            current = (n / i) % 10; // 当前位
            after = n - (n / i) * i;  // 低位

            if (current == 0)
                //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
                count = count + before * i;
            else if(current == 1)
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count = count + before * i + after + 1;
            else if (current > 1)
                // 如果大于1,出现1的次数由高位决定,（高位数字+1）* 当前位数
                count = count + (before + 1) * i;
            //前移一位
            i = i * 10;
        }
        return count;
    }

}
