package leetcode.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 有效的括号20 {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //Deque<Character> deque = new ArrayDeque<>(); 两种栈的实现
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch.equals('(') || ch.equals('[') || ch.equals('{')){
                stack.push(ch);
            }else if (ch.equals(')')){
                if (stack.isEmpty() || !stack.pop().equals('(')){
                    return false;
                }
            }else if (ch.equals(']')){
                if (stack.isEmpty() || !stack.pop().equals('[')){
                    return false;
                }
            }else {
                if (stack.isEmpty() || !stack.pop().equals('{')){
                    return false;
                }
            }

        }

        if (stack.isEmpty()) {
            return true;
        }else {
            return false;
        }

    }
}
