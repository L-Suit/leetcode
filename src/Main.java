
import com.sun.org.apache.xerces.internal.impl.dv.XSSimpleType;

import java.util.*;

public class Main {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.data = val;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str= sc.next();
        boolean ans = isValid(str);
        System.out.println(ans);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        char [] chars = s.toCharArray();
        for (char ch :chars) {
            //如果是左括号，压栈
            if (!map.containsKey(ch)){
                stack.push(ch);
            }else {//右括号
                //判断栈顶是否能匹配上
                if (stack.size()!=0 && stack.peek()== map.get(ch)){
                    stack.pop();
                }else return false;
            }
        }
        if(stack.size()!=0) return false;
        else return true;
    }

}