package leetcode.string;

import java.util.Arrays;

/**
 * @author lishihao
 */
public class 反转字符串2 {
    public static void main(String[] args) {
        反转字符串2 fanzhuan = new 反转字符串2();
        String s = fanzhuan.reverseStr("abcdefg", 8);
        System.out.println(s);
    }

    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int l=0,mid=k;
        while (l<=s.length()-1){
            if (mid-1<=charArray.length-1){
                reverse(charArray,l,mid-1);
            } else {
                reverse(charArray,l,charArray.length-1);
            }

            l+= 2*k;
            mid += 2*k;
        }


        return String.copyValueOf(charArray);
    }



    private char[] reverse (char[] chars,int l,int r){
        while (l<r){
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return chars;
    }
}
