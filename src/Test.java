import utils.QuickSort;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        int a = 0,b=0;
        int x = a&b,y=a|b,z=a^b;
        System.out.println("a&b:" + x);
        System.out.println("a|b:"+y);
        System.out.println("a^b:"+z);
    }

}
