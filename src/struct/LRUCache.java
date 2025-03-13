package struct;

import struct.DLinkedList;
import utils.Print;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    //双向链表实现o（1）时间的替换
    DLinkedList linkedList = new DLinkedList();

    //使用哈希表实现快速查询
    Map<Integer,DLinkedList> map = new HashMap<>();

    int capacity;
     DLinkedList head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;


        //更新链表中访问节点的位置
        DLinkedList node = map.get(key);
        insertToHead(node);


        Print.printDLinkedList(head);
        return node.value;
    }


    public void put(int key, int value) {

        if (!map.containsKey(key)){
            //没有的话新建节点，放表头
            DLinkedList node = new DLinkedList(key,value);
            if (map.size()==0){
                head=node;
                tail=node;
            }
            insertToHead(node);
            map.put(key,node);

            System.out.println("新建节点后");
            Print.printDLinkedList(head);

            //长度超过容量，删除表尾元素
            if (map.size() > capacity){
                // 如果超出容量，删除双向链表的尾部节点
                delete(tail);
                // 删除哈希表中对应的项
                map.remove(tail.key);
                tail=tail.preNode;
                System.out.println("删除超量元素后");
                Print.printDLinkedList(head);
            }
        }else {
            //有节点，更新值，放表头
            DLinkedList node = map.get(key);
            node.value =value;
            moveToHead(node);
            System.out.println("更新节点数值后");
            Print.printDLinkedList(head);
        }
    }


    private void moveToHead(DLinkedList node) {
        //链表只有一个结点
        if (head==tail) return;

        delete(node);
        //插入到头
        insertToHead(node);
    }

    private void insertToHead(DLinkedList node) {
        if (node==head&&head!=tail) return;
        //当加到头的是尾结点时，并且不是只有一个元素
        if (node==tail && head!=tail){
            head=node;
            tail=node.preNode;
            return;
        }
        node.nextNode = head;
        node.preNode = tail;
        tail.nextNode = node;
        head.preNode = node;
        head=head.preNode;
    }

    private void delete(DLinkedList node){
        //删除前后关系
        node.preNode.nextNode=node.nextNode;
        node.nextNode.preNode = node.preNode;
    }


}
