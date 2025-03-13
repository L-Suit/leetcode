package leetcode;

import struct.ListNode;

public class 链表相交0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        int diffLen;
        ListNode curA = headA, curB = headB;
        while (curA != null){
            lenA++;
            curA = curA.next;
        }
        while (curB != null){
            lenB++;
            curB = curB.next;
        }
        //重置AB头指针
        curA = headA;
        curB = headB;
        if (lenA > lenB){
            diffLen = lenA - lenB;
            while (diffLen > 0){//移动A指针difflen步
                curA = curA.next;
                diffLen--;
            }
        }else if (lenA < lenB){
            diffLen = lenB - lenA;
            while (diffLen > 0){//移动B指针difflen步
                curB = curB.next;
                diffLen--;
            }
        }

        // 同时移动AB指针，看是否会相遇
        while (curA !=null && curB != null){
            if (curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }

}
