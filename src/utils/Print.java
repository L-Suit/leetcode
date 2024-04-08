package utils;

import struct.DLinkedList;

public class Print {
    public static void printDLinkedList(DLinkedList list){
        if (list.nextNode==list) {
            System.out.print(list.value);
            System.out.println();
            return;
        }

        System.out.print(list.value);
        DLinkedList p = list.nextNode;
        while(p!= list){
            System.out.print("<--->"+p.value);
            p=p.nextNode;
        }
        System.out.println();
    }
}
