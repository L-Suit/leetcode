package leetcode;

import struct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 环形链表二142 {

    //方法一：使用Set判断是否遇到重复元素
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (set.contains(cur)){
                return cur;
            }else {
                set.add(cur);
            }
            cur = cur.next;
        }


        return null;
    }
}
