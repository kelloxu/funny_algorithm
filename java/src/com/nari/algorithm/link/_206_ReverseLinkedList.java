package com.nari.algorithm.link;

import com.nari.algorithm.model.LinkNode;

public class _206_ReverseLinkedList {

    public static LinkNode reverse(LinkNode head) {

        // 方法1： 迭代方法
//        LinkNode cur = head;
//        LinkNode prev = null;
//        while (cur != null) {
//            LinkNode temp = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = temp;
//        }
//        return prev;

        // 方法2：递归方法
        return reverse_recursion(head, null);

    }

    public static LinkNode reverse_recursion(LinkNode cur, LinkNode prev) {
        if (cur == null) {
            return prev;
        }

        LinkNode temp = cur.next;
        cur.next = prev;
        prev = cur;
        cur = temp;

        return reverse_recursion(cur, prev);
    }

    public static void main(String[] args) {
        LinkNode node5 = new LinkNode(12, null);
        LinkNode node4 = new LinkNode(3, node5);
        LinkNode node3 = new LinkNode(7, node4);
        LinkNode node2 = new LinkNode(4, node3);
        LinkNode node1 = new LinkNode(8, node2);

        LinkNode res = reverse(node1);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("NULL");


        int [] a = {8, 6, 3, 2, 1};

    }
}
