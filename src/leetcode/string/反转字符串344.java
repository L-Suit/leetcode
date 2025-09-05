package leetcode.string;

public class 反转字符串344 {
    public String reverseStr(String s, int k) {
        int len = s.length();
        int l =0;
        char[] chars = s.toCharArray();
        while (l<len){
             //判断是否超过数组长度
            if (len-l < k){
                //剩余都反转
                reverseString(chars,l,len-1);
                break;
            }else if (len-l < 2*k){
                reverseString(chars,l,l+k-1);
                break;
            }else if (len-l >= 2*k){
                //反转前k个
                reverseString(chars,l,l+k-1);
                l = l+2*k;
            }

        }
        String str = new String(chars);
        return str;
    }

    //反转字符串l~r的范围
    public static void reverseString(char[] s,int l,int r) {
        while (l<r){
            //交换字符
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
