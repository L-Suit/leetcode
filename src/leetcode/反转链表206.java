package leetcode;

import struct.ListNode;

public class 反转链表206 {
    public static void main(String[] args) {

    }
    /*  迭代方式
public ListNode reverseList(ListNode head) {
        if ( head == null) return null;
        ListNode p=null,r = head;

        while (r!=null){//双指针同时移动
            ListNode temp = r.next;
            r.next = p;
            p = r;
            r = temp;
        }
        return p;

    }*/
    public ListNode reverseList(ListNode head) {
        if ( head == null) return null;
        ListNode p=null,r = head;
        ListNode ans = reverse(p,r);

        return ans;

    }

    public static ListNode reverse(ListNode head,ListNode cur){
        if ( cur == null) return head; // 递归跳出条件
        ListNode temp = cur.next;
        cur.next = head;
        head = cur;
        cur = temp;
        return  reverse(head,cur);
    }
}
