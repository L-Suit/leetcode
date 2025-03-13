package leetcode.stackqueue;

public class 删除字符串中的所有相邻重复项1047 {

    public static void main(String[] args) {
        System.out.println(new 删除字符串中的所有相邻重复项1047().removeDuplicates("abbaca"));
    }
    public String removeDuplicates(String s) {
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
}
