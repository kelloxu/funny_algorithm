package com.nari.algorithm.link;

import com.nari.algorithm.model.LinkNode;

/**
 * Author: Xu Jiong
 * Date: 2022/8/19 15:43
 * Description: 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 解题思路：归并排序
 */
public class _148_SortList {

    public static LinkNode sortList(LinkNode head) {
        return head == null ? null : mergeSort(head);
    }

    /**
     * 递归实现归并排序
     *
     * @param head 原始链表的头部节点
     * @return 排好序的链表的头部节点
     */
    private static LinkNode mergeSort(LinkNode head) {

        // 递的过程（将链表切成左右两个链表，直到每个子链表为单个节点）
        // 原始链表： 4->3->1->8->7->9->2->11->6->5
        // 第一次递： 4->3->1->8->7  9->2->11->6->5
        // 第二次递： 4->3  1->8->7  9->2 11->6->5
        // 第三次递： 4 3   1 8->7   9 2   11 6->5
        // 第四次递： 4 3   1  8 7   9 2   11  6 5

        // 递的结束条件
        if (head.next == null) {
            return head;
        }

        LinkNode s = head;   // 慢指针
        LinkNode f = head;   // 快指针
        LinkNode pre = null; // 链表中间节点的前继节点，在此断链
        while (f != null && f.next != null) {
            pre = s;
            s = s.next;
            f = f.next.next;
        }
        pre.next = null;
        LinkNode l = mergeSort(head);
        LinkNode r = mergeSort(s);

        // 归的过程（合并）
        // 第一次归： 4 3   1  7->8   9 2   11  5->6
        // 第二次归： 3->4   1->7>8   2->9   5->6>11
        // 第三次归： 1->3->4->7->8   2->5->6->9->11
        // 第四次归： 1->2->3->4->5->6->7->8->9->11
        return merge(l, r);
    }

    /**
     *  合并两个有序链表
     * @param l 左边的有序链表
     * @param r 右边的有序链表
     * @return 合并后链表的头部节点
     */
    private static LinkNode merge(LinkNode l, LinkNode r) {
        LinkNode dummyHead = new LinkNode(0);
        LinkNode cur = dummyHead;  // cur相当于移动的浮标
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;   // 当前节点指向最小值
                cur = cur.next; // 当前节点移动到最小值
                l = l.next;     // 更新l
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }

        // cur 指向链表中最有一个元素（即最大值），排序完成
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // 4->3->1->8->7->9->2->11->6->5
        LinkNode node10 = new LinkNode(5, null);
        LinkNode node9 = new LinkNode(6, node10);
        LinkNode node8 = new LinkNode(11, node9);
        LinkNode node7 = new LinkNode(2, node8);
        LinkNode node6 = new LinkNode(9, node7);
        LinkNode node5 = new LinkNode(7, node6);
        LinkNode node4 = new LinkNode(8, node5);
        LinkNode node3 = new LinkNode(1, node4);
        LinkNode node2 = new LinkNode(3, node3);
        LinkNode node1 = new LinkNode(4, node2);

        LinkNode sorted = sortList(node1);
        while (sorted != null) {
            System.out.print(sorted.val + "->");
            sorted = sorted.next;
        }
    }
}
