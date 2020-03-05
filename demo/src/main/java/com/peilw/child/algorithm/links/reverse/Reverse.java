package com.peilw.child.algorithm.links.reverse;

import com.peilw.child.algorithm.links.Node;

public class Reverse {
    //遍历反转法
    public static Node Reverse(Node head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.getNext() == null) {
            return head;
        }
        //前一个节点指针
        Node preNode = null;
        //当前节点指针
        Node curNode = head;
        //下一个节点指针
        Node nextNode = null;

        while (curNode != null) {
            nextNode = curNode.getNext();//nextNode 指向下一个节点
            curNode.setNext(preNode);//将当前节点next域指向前一个节点
            preNode = curNode;//preNode 指针向后移动
            curNode = nextNode;//curNode指针向后移动
        }

        return preNode;
    }

    //递归调用
    public static Node RecursiveReverse(Node head) {
        if (head == null || head.next == null) return head;
        else {
            Node newHead = RecursiveReverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

    //插入法
    public static void ReverseInsert(Node head) {
        if (head == null || head.next == null) return;
        Node cur = null;
        Node next = null;
        cur = head.next.next;
        head.next.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        //head = Reverse(head);
        //ReverseInsert(head);
        head = RecursiveReverse(head);
        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }
}
