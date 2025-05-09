package bishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 生物钟 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int round = Integer.parseInt(st.nextToken());
        for (int i = 0; i < round; i++) {
            st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            int hour = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < day; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            if (sum > hour*day){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }


    }
}
