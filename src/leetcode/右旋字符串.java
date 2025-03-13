package leetcode;

import java.util.Scanner;

public class 右旋字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k =  sc.nextInt();
        String str = sc.next();
        k = k % str.length();
        String str1 = str.substring(str.length() - k, str.length());
        str1.concat(str);
        StringBuilder front = new StringBuilder(str.substring(0, str.length() - k));
        StringBuilder tail = new StringBuilder(str.substring(str.length() - k, str.length()));

        tail = tail.append(front);
        System.out.println(tail);
    }
}
