import java.util.concurrent.locks.ReentrantLock;

public class Singleton {
    private volatile static Singleton instance;
    private static ReentrantLock lock = new ReentrantLock();

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            lock.lock();
            try {
                //防止上锁前实例被占用
                if (instance == null) {
                    instance = new Singleton();
                }
            } finally {
                lock.unlock();
            }
        }else {
            System.out.println("唯一实例已被占用");
        }
        return instance;
    }
}