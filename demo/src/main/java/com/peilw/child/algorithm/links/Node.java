package com.peilw.child.algorithm.links;

import lombok.Data;

@Data
public class Node<T, U extends Node> {
    public T data;
    public U next;

    public Node(T data, U next) {
        this.data = data;
        this.next = next;
    }
    public Node(){

    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data +  '}';
    }

    public Node(T data){
        this.data = data;
    }
}
