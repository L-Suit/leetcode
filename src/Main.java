import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        String str = sc.next();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        int count =0;
        int sum=0;
        for (int i = 0; i < n; i++) {

            if (i>0 && chars[i] != chars[i-1]){//新物品
                count=0;
            }

            if (count<k){
                sum++;
                count++;
            }

        }
        System.out.println(sum);

    }*/

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round =  Integer.parseInt(br.readLine());
        Long costSum = 0l;
        long[] cost = new long[9000000];

        //计算每个数字的cost
        for (int i = 1 ; i < cost.length; i++) {
            int num =i;
            long numcost =num;
            while (num >0){
                long back = num & (-num);
                num -= back;
                long costPer = Math.max(0,back-1);
                numcost = numcost | costPer;
            }
            cost[i] = numcost;
        }


        while (round-->0){
            long n = Integer.parseInt(br.readLine());
            costSum =0l;

            for (int i = 1; i <= n; i++) {
                costSum += cost[i];
            }
            System.out.print(costSum+" ");
        }

    }


}