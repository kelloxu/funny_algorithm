package com.nari.algorithm.model;

/**
 * Author: Xu Jiong
 * Date: 2022/5/25 16:44
 * Description:
 */
public class Node {

    private int val;
    private Node prev;
    private Node next;

    public Node(int val) {this.val = val;}

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
