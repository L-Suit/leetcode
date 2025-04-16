import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test01 {
    static  long maxji = Long.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        String numsstr[] = str.split(",");
        int nums[] = new int[numsstr.length];

        for (int i = 0; i < numsstr.length; i++) {
            nums[i] = Integer.valueOf(numsstr[i]);
        }


        backtrace(nums,0,1l,0);
        System.out.println(maxji);
    }

    private static void backtrace(int[] nums,int index,Long ji,int k) {
        //跳出
        if (k==3){
            maxji = Math.max(ji,maxji);
            return;
        }

        for (int i = index ; i <nums.length-(3-k)+1 ; i++) {
            if (nums[i] ==0 ) continue;
            ji *= nums[i];
            backtrace(nums,i+1,ji,k+1);
            ji /= nums[i];
        }

    }
}
