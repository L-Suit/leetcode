package leetcode.linklist;

import struct.ListNode;

import java.util.List;

/**
 * @author lishihao
 */
public class 排序链表 {
    public static void main(String[] args) {

    }
    public ListNode sortList(ListNode head) {
        if (head==null || head.next ==null){
            return head;
        }

        ListNode l=head,r=head,mid=head;
        //find mid
        while (r!=null && r.next!=null){
            mid = l;
            l = l.next;
            r = r.next.next;
        }

        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(l);

        return merge(left,right);
    }



    public ListNode merge (ListNode left,ListNode right){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;


        while (left!=null && right!=null){
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left ==null){
            cur.next = right;
        }else {
            cur.next = left;
        }

        return dummy.next;
    }
}
