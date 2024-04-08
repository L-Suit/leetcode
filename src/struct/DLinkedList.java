package struct;

public class DLinkedList {
    //双向链表
    public int key;
    public int value;

    public DLinkedList preNode;
    public DLinkedList nextNode;

    public DLinkedList() {
    }

    public DLinkedList(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
