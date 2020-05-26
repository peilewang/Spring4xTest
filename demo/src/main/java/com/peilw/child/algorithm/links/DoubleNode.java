package com.peilw.child.algorithm.links;

import lombok.Data;

@Data
public class DoubleNode<T> {
    public T data;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode() {

    }

    public DoubleNode(T data, DoubleNode next, DoubleNode pre) {
        this.data = data;
        this.next = next;
        this.pre = pre;
    }

    public DoubleNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DoubleNode{" + "data=" + data + '}';
    }
}
