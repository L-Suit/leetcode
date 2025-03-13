package bingfa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorPool {

    public static void main(String[] args) {
        // 创建一个固定大小为5的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 模拟10个文件下载任务
        for (int i = 1; i <= 10; i++) {
            Runnable worker = new FileDownloader("File_" + i);
            executor.execute(worker); // 将任务提交给线程池
        }

        // 关闭线程池，不再接受新的任务，但会继续处理已经提交的任务
        executor.shutdown();
        System.out.println("All download tasks have been submitted.");

        try {
            // 等待所有任务完成
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Not all tasks completed within the timeout period.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All download tasks are completed.");
    }

    // 文件下载任务类
    static class FileDownloader implements Runnable {
        private final String fileName;

        public FileDownloader(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " starts downloading " + fileName);
            try {
                // 模拟下载过程
                Thread.sleep((long) (Math.random() * 1000)); // 随机等待时间，表示下载所需的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished downloading " + fileName);
        }
    }
}