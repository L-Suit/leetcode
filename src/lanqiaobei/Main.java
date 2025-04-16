package lanqiaobei;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        long ans = 0,sum = 0,jiecheng=1;
        for (int i = 1; i < 100; i++){
            jiecheng=1;
            sum = i*(i+1)/2;
            for (int j = 1; j <=i ; j++) {
                jiecheng *= j;
            }

            if ((sum-jiecheng)%100 ==0){
                ans ++;
            }
        }

        for (long i = 100; i < 2024041331404202l; i++) {
            System.out.println(i);
            sum = i*(i+1)/2;
            System.out.println(sum);
            if (sum%100 == 0){
                ans++;
            }
        }

        System.out.println(ans);
    }
}
