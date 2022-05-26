package com.nari.algorithm.link;

import com.nari.algorithm.model.Node;

/**
 * Author: Xu Jiong
 * Date: 2022/5/25 16:43
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *  链接：https://leetcode.cn/problems/design-linked-list/
 *  说明：原题是使用单向链表或双向链表的结构来设计链表，本代码只使用双向链表来设计。
 *
 *  */
public class _707_DesignDoubleLinkedList {

    static class MyLinkedList {

        private Node dummyHead;
        private Node dummyTail;
        private int count;

        public MyLinkedList() {
            this.dummyHead = new Node(0);
            this.dummyTail = new Node(0);
            dummyHead.setNext(dummyTail);
            dummyTail.setPrev(dummyHead);
            this.count = 0;
        }

        /**
         * 根据索引获取节点
         * @param index 索引
         * @return 节点
         */
        private Node getNode(int index) {
            Node node;
            int curIndex;

            // 从尾部往前查找
            if (index >= this.count / 2) {
                node = this.dummyTail.getPrev();
                curIndex = this.count - 1;  // 当前索引在最后一个节点
                while(curIndex > index) {
                    node = node.getPrev();  // 获取前一个节点
                    curIndex -= 1;  // 更新索引
                }
            }

            // 从头部往后查找
            else {
                node = this.dummyHead.getNext();
                curIndex = 0;  // 当前索引在第一个节点
                while (curIndex < index) {
                    node = node.getNext();  // 获取后一个节点
                    curIndex += 1;  // 更新索引
                }
            }
            return node;
        }

        /**
         * 抽象出公共方法：添加新节点
         * @param prev 新节点的前一个节点
         * @param next 新节点的后一个节点
         * @param newNode 新节点
         */
        private void addNewNode(Node prev, Node next, Node newNode) {
            this.count += 1;
            prev.setNext(newNode);
            next.setPrev(newNode);
            newNode.setPrev(prev);
            newNode.setNext(next);
        }


        /**
         * 根据索引获取节点的值
         * @param index 索引
         * @return 节点的值
         */
        public int get(int index) {
            if (index >= 0 && index < this.count) {
                return this.getNode(index).getVal();
            } else {

                // 超出索引范围，返回 -1
                return -1;
            }
        }

        /**
         * 在头部添加一个节点
         * @param val 待添加节点的值
         */
        public void addAtHead(int val) {
            Node newNode = new Node(val);
            addNewNode(this.dummyHead, this.dummyHead.getNext(), newNode);
        }

        /**
         * 在尾部添加一个节点
         * @param val 待添加的节点的值
         */
        public void addAtTail(int val) {
            Node newNode = new Node(val);
            addNewNode(this.dummyTail.getPrev(), this.dummyTail, newNode);
        }

        /**
         * 在指定索引处添加一个节点
         * @param index 索引
         * @param val 待添加节点的值
         */
        public void addAtIndex(int index, int val) {
            if (index <= 0) {
                addAtHead(val);
                return;
            } else if (index == this.count) {
                addAtTail(val);
                return;
            } else if (index > this.count) {
                return;
            }
            Node newNode = new Node(val);

            addNewNode(this.getNode(index).getPrev(), this.getNode(index), newNode);
        }

        /**
         * 删除指定索引的值
         * @param index 索引
         */
        public void deleteAtIndex(int index) {
            if (index >= 0 && index < this.count) {
                Node node = this.getNode(index);  // 找到待删除的节点
                Node tempPrev = node.getPrev();
                Node tempNext = node.getNext();
                this.count -= 1;
                tempPrev.setNext(tempNext);
                tempNext.setPrev(tempPrev);
            }
        }

    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // 报错示例1
        list.addAtIndex(0, 10);
        list.addAtIndex(0, 20);
        list.addAtIndex(1, 300);
        System.out.println("list.get(0) = " + list.get(0));
        printList(list);

        // 报错示例2
//        list.addAtHead(5);
//        list.addAtIndex(1, 2);
//        System.out.println("list.get(1) = " + list.get(1));
//        list.addAtHead(6);
//        list.addAtTail(2);
//        System.out.println("list.get(3) = " + list.get(3));
//        list.addAtTail(1);
//        System.out.println("list.get(5) = " + list.get(5));
//        list.addAtHead(2);
//        System.out.println("list.get(6) = " + list.get(6));
//        list.addAtHead(2);
//        printList(list);

//        list.addAtHead(7);
//        list.addAtHead(2);
//        list.addAtHead(1);
//        list.addAtIndex(0, 10);
//        list.deleteAtIndex(2);
//        list.addAtHead(6);
//        list.addAtTail(4);
//        System.out.println("list.get(4) = " + list.get(4));
//        list.addAtHead(4);
//        list.addAtIndex(5, 0);
//        list.addAtHead(6);
//        printList(list);
//        System.out.println();
//        System.out.println("list.get(4) = " + list.get(1));
    }

    public static void printList(MyLinkedList list) {
        System.out.println("My linked list is :");
        Node cur = list.dummyHead;
        while (cur.getNext() != null) {
            System.out.print(cur.getVal() + "->");
            cur = cur.getNext();
        }
        System.out.print(cur.getVal());
    }
}
