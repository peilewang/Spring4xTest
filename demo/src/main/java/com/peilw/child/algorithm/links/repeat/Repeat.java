package com.peilw.child.algorithm.links.repeat;

import com.peilw.child.algorithm.links.Node;

public class Repeat {
    //顺序删除
    public static void removeDup(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node outerCur = head.next;//用于外层循环
        Node innerCur = null;//内层循环用来遍历outerCur后面的节点
        Node innerPre = null;//innerCur的前驱节点
        for (; outerCur != null; outerCur = outerCur.next) {
            for (innerCur = outerCur.next, innerPre = outerCur; innerCur != null; ) {
                //找到重复节点并删除
                if (outerCur.data == innerCur.data) {
                    innerPre.next = innerCur.next;
                    innerCur = innerCur.next;
                } else {
                    innerPre = innerCur;
                    innerCur = innerCur.next;
                }
            }
        }
    }
//递归法

    public static void main(String[] args) {
        int i = 1;
        Node head = new Node();
        head.next = null;
        Node tmp = null;
        Node cur = head;
        for (; i < 7; i++) {
            tmp = new Node();
            if (i % 2 == 0) tmp.data = i + 1;
            else if (i % 3 == 0) tmp.data = i;
            else tmp.data = i;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        System.out.println("删除重复节点前： ");
        for (cur = head.next; cur != null; cur = cur.next)
            System.out.print(cur.data + " ");
        removeDup(head);
        System.out.print("删除重复节点后：");
        for (cur = head.next; cur != null; cur = cur.next)
            System.out.print(cur.data + " ");
    }
}
