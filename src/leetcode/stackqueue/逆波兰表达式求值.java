package leetcode.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 逆波兰表达式求值 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String str:tokens) {
            if (str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")){//非数字，进行运算
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                Integer ans = Calculate(num2,num1,str);
                stack.push(ans);

            }else {//数字，压栈
                Integer num =Integer.valueOf(str);
                stack.push(num);
            }
        }

        return stack.pop();
    }

    private int Calculate(Integer num2, Integer num1, String str) {//1是先弹出的
        switch (str){
            case "+":return num2+num1;
            case "-":return num2-num1;
            case "*":return num2*num1;
            case "/":return num2/num1;
        }

        return 0;
    }
}
