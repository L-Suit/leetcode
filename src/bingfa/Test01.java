package bingfa;

import leetcode.stackqueue.滑动窗口最大值;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Test01 {
    public static void main(String[] args) {
        滑动窗口最大值 s = new 滑动窗口最大值();
        int[] nums = s.maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
