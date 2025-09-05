package leetcode.string;

import java.util.Scanner;

/**
 * @author lishihao
 */
public class 替换数字 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch>='0' && ch<='9') {
                sb.append("number");
            }else {
                sb.append(ch);
            }
        }

        System.out.println(sb);
    }

    public void main(){


    }
}
