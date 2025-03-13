package struct;



/*
* MyLinkedList() 初始化 MyLinkedList 对象。
int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
* */
public class MyLinkedList {
    private Node head;
    private Node tail;

    public int val;

    public MyLinkedList prev;
    public MyLinkedList next;

    public MyLinkedList() {
        head = null;
        tail = null;
    }


    public MyLinkedList(int val, MyLinkedList prev, MyLinkedList next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public int get(int index) {
        int i =0;
        MyLinkedList p = this;
        while (p!=null){
            if (i == index){
                return p.val;
            }
            p = p.next;
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        MyLinkedList node = new MyLinkedList(val,null,this);
        this.prev = node;
    }

    public void addAtTail(int val) {
        MyLinkedList node = new MyLinkedList(val,null,null);
        MyLinkedList p = this;
        while (p.next!=null){
            p = p.next;
        }
        p.next = node;
        node.prev = p;
    }

    public void addAtIndex(int index, int val) {
        MyLinkedList node = new MyLinkedList(val,null,null);
        int i = 0;
        MyLinkedList p = this;
        while (p!=null){
            if (i == index){//找到位置，进行插入操作
                node.next = p;
                p.prev.next = node;
                node.prev = p.prev;
                p.prev = node;
                break;
            }
            i++;
            p = p.next;
        }
        if (i == index){//插入到最后
            this.addAtTail(val);
        }
    }

    public void deleteAtIndex(int index) {
        int i = 0;
        MyLinkedList p = this;
        while (p!=null){
            if (i == index){//删除操作
                if (i==0){//如果是删除首节点
                    // 通过头结点，更新第一个节点位置,太麻烦了，省时间跳过
                    // head = current.next;
                    break;
                }
                p.prev.next = p.next;
                p.next.prev = p.prev;
                break;
            }
            i++;
            p=p.next;
        }
    }
}
