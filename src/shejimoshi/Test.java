package shejimoshi;

public class Test {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.getClass());
        System.out.println(singleton);
    }
}
