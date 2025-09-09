package leetcode.stackqueue;

public class 删除字符串中的所有相邻重复项1047 {

    public static void main(String[] args) {
        System.out.println(new 删除字符串中的所有相邻重复项1047().removeDuplicates("abbaca"));
    }
    public String removeDuplicates0(String s) {
        if (s.length()<=1) return s;
        StringBuffer sb = new StringBuffer();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (sb.length() > 0 && c.equals(sb.charAt(sb.length()-1))){
                sb.delete(sb.length()-1,sb.length());
            }else {
                sb.append(c);
            }

        }


        return sb.toString();
    }
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (sb.length() ==0 ){
                sb.append(ch);
            }else if (ch!=sb.charAt(sb.length()-1)){
                //和前面不相等，append
                sb.append(ch);
            }else {
                sb.delete(sb.length()-1,sb.length());
            }
        }

        return sb.toString();
    }

}
