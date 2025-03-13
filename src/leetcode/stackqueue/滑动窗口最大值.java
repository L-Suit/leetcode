package leetcode.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Mydeque mydeque = new Mydeque();

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

    class Mydeque {
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
}
