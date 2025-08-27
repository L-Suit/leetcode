package leetcode.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lishihao
 */
public class LRUCache {

    class DLinkedNode{
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;
        public  DLinkedNode(){}

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int size;
    int capacity;
    DLinkedNode head;
    DLinkedNode tail;

    Map<Integer,DLinkedNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size =0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        head.prev = tail;
        tail.next = head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            DLinkedNode node = map.get(key);
            moveToHead(node);
            return node.val;
        }else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            //更新值
            DLinkedNode node = map.get(key);
            node.val = value;
            //放队头
            moveToHead(node);
        }else {
            //放队头
            DLinkedNode node = new DLinkedNode(key,value);
            map.put(key,node);
            addToHead(node);
            size++;

            //判断容量，是否删除
            if (size >capacity){
                size--;
                map.remove(tail.prev.key);
                delNode(tail.prev);
            }
        }
    }

    public void addToHead(DLinkedNode node){
        head.next.prev =  node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    public void delNode(DLinkedNode node){
        node.prev .next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(DLinkedNode node){
        delNode(node);
        addToHead(node);
    }

}
