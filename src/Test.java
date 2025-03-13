import utils.QuickSort;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5); // 创建一个包含5个线程的线程池
        for (int i = 0; i < 10; i++) {
            executor.submit(new Task(i)); // 提交任务到线程池
        }
        executor.shutdown(); // 关闭线程池
    }

    static class Task implements Runnable {
        private final int taskId;

        Task(int id) {
            this.taskId = id;
        }

        public void run() {
            System.out.println("Executing Task " + taskId);
        }
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return 123; // 返回的结果
        }
    }

}
