package leetcode.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class 滑动窗口最大值 {

    public static void main(String[] args) {
        滑动窗口最大值 o = new 滑动窗口最大值();
        int[] num = new int[]{1,3,-1,-3,5};
        int[] ints = o.maxSlidingWindow(num, 3);
    }
    public int[] maxSlidingWindow0(int[] nums, int k) {
        Mydeque0 mydeque = new Mydeque0();

        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            mydeque.push(nums[i]);
        }
        ans[0] = mydeque.peek();

        for (int i = k; i < nums.length; i++) {
            mydeque.push(nums[i]);
            mydeque.pop(nums[i-k]);
            ans[i-k+1] = mydeque.peek();
        }

        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Mydeque mydeque = new Mydeque();
        int[] ans = new int[nums.length - k+1];
        for (int i = 0; i < k; i++) {
            mydeque.push(nums[i]);
        }


        for (int j = k; j < nums.length; j++) {
            ans[j-k] = mydeque.peek();
            mydeque.push(nums[j]);
            if (mydeque.peek()==nums[j-k]){
                mydeque.pop();
            }

        }

        ans[nums.length-k] = mydeque.peek();

        return ans;
    }

    class Mydeque0 {
        Deque<Integer> deque = new ArrayDeque<>();
        public void push(int num) {
            while (deque.peekFirst() != null && deque.peekFirst() < num){//队头元素小于当前元素，队尾一直pop
                deque.pollFirst();
            }
            deque.offerFirst(num);
        }

        public void pop(int num) {
            if (deque.peekLast() != null && deque.peekLast() == num){
                deque.pollLast();
            }
        }

        public int peek() {
            return deque.peekLast();
        }


    }

    class Mydeque{
        Deque<Integer> deque = new ArrayDeque<>();

        public void push(int num){
            if (!deque.isEmpty() &&num<=deque.peekLast()){
                deque.offerLast(num);
            }else {
                while (!deque.isEmpty() && deque.peekLast() < num){
                    deque.pollLast();
                }
                deque.offerLast(num);
            }
        }

        public Integer pop(){
            return deque.pollFirst();
        }

        public Integer peek(){
            return deque.peekFirst();
        }
    }
}
