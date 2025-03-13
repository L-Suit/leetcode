package struct;

public class DLinkedList {
    //双向链表
    public int key;
    public int value;

    public DLinkedList preNode;
    public DLinkedList nextNode;

    public DLinkedList() {
    }

    public DLinkedList(int value) {
        this.value = value;
    }

    public DLinkedList(int value, DLinkedList preNode, DLinkedList nextNode) {
        this.value = value;
        this.preNode = preNode;
        this.nextNode = nextNode;
    }

    public DLinkedList(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
