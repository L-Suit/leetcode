package leetcode;

import struct.ListNode;

public class 两两交换链表中的节点24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next!=null && cur.next.next != null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            ListNode third = second.next;

            cur.next = second;
            second.next = first;
            first.next = third;

            cur = cur.next.next;

        }


        return dummy.next;
    }
}
