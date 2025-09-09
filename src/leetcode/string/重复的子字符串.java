package leetcode.string;

/**
 * @author lishihao
 */
public class 重复的子字符串 {
    public static void main(String[] args) {

        重复的子字符串 o = new 重复的子字符串();
        boolean abab = o.repeatedSubstringPattern("aba");
        System.out.println(abab);
    }

    public boolean repeatedSubstringPattern(String s) {
        boolean flag = false;
        int len = s.length();
        for (int i = 0; i <len; i++) {
            //取0-i子串
            String part = s.substring(0,i+1);
            if (len % part.length() !=0){
                continue;
            }
            int j = i+1;
            if (j ==len){
                return false;
            }
            while (j<len){
                if (s.charAt(j)!=part.charAt(j % part.length())){
                    break;
                }
                j++;
            }
            //走完一轮，校验是不是答案
            if (j==len && j%part.length() == 0){
                return true;
            }

        }


        return  flag;
    }
}
