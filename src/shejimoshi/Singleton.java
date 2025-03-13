package shejimoshi;

public class Singleton {

/*    //饿汉式单例测试,反射会破坏，不推荐
    // 1、私有化构造⽅法
    private Singleton(){}

    //2、定义⼀个静态变量指向⾃⼰类型
    private final static Singleton instance = new Singleton();
    // 3、对外提供⼀个公共的⽅法获取实例
    public static Singleton getInstance(){
        return instance;
    }*/

    //双重检查锁（DCL， 即 double-checked locking）
    // 1、私有化构造⽅法
    private Singleton() {}
    // 2、定义⼀个静态变量指向⾃⼰类型
    private volatile static Singleton instance;
    // 3、对外提供⼀个公共的⽅法获取实例

    public static Singleton getInstance() {
        // 第⼀重检查是否为 null
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    // new 关键字创建对象不是原⼦操作
                    instance = new Singleton();

                }

            }
        }
        return instance;
    }
}
