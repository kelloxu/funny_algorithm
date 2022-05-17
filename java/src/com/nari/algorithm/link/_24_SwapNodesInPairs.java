package com.nari.algorithm.link;

/**
 * Author: Xu Jiong
 * Date: 2022/5/17 16:50
 * Description:
 */

import com.nari.algorithm.model.LinkNode;

public class _24_SwapNodesInPairs {

    public static LinkNode swapPairs(LinkNode head) {

        // 新增虚节点，指向 head
        LinkNode dumpy = new LinkNode(0);
        dumpy.next = head;

        // dumpy 赋给 cur
        LinkNode cur = dumpy;

        // 开始迭代
        // 1. 当 cur.next = None 时，说明已经遍历到最后一个节点，迭代可以结束了
        // 2. 当 cur.next = None 时，说明链表的节点数是奇数，还剩最后一个节点，无法交换了，迭代也可以结束了
        while (cur.next != null && cur.next.next != null) {
            LinkNode temp1 = cur.next;
            LinkNode temp2 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = temp1;
            cur.next.next.next = temp2;
            cur = cur.next.next;
        }
        return dumpy.next;
    }


    public static void main(String[] args) {

        LinkNode node5 = new LinkNode(5, null);
        LinkNode node4 = new LinkNode(4, node5);
        LinkNode node3 = new LinkNode(3, node4);
        LinkNode node2 = new LinkNode(2, node3);
        LinkNode node1 = new LinkNode(1, node2);

        LinkNode res = swapPairs(node1);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("NULL");
    }

}
