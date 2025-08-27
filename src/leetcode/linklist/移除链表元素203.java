package leetcode.linklist;

import struct.ListNode;

public class 移除链表元素203 {
    public static void main(String[] args) {

    }

    public ListNode removeElements0(ListNode head, int val) {
        if (head == null) {
            return head;
        }
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

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        ListNode p = dummy;
        dummy.next = head;
        while (dummy.next != null){
            if (dummy.next.val == val){
                dummy.next = dummy.next.next;
                continue;
            }
            dummy = dummy.next;
        }

        return p.next;
    }


}
