package leetcode;

import struct.ListNode;

public class 移除链表元素203 {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        //虚拟节点
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;

        while (p.next !=null){
            if (p.next.val==val){
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }

        return dummy.next;
    }

}
