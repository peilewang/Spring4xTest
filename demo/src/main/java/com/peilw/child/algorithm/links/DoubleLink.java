package com.peilw.child.algorithm.links;

public class DoubleLink {
    public static void main(String[] args) {
        DoubleLink doubleLink = new DoubleLink();
        DoubleNode doubleNode = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        DoubleNode doubleNode4 = new DoubleNode(4);
        doubleLink.add(doubleNode);
        doubleLink.add(doubleNode2);
        doubleLink.add(doubleNode3);
        doubleLink.add(doubleNode4);
        System.out.println("删除之前》》》》》》》》》》》》》》》》》");
        doubleLink.listNode();
        System.out.println("删除之后》》》》》》》》》》》》》》》》》");
        doubleLink.remove(doubleNode2);
        doubleLink.listNode();


    }

    private DoubleNode head = new DoubleNode();

    public int size() {
        DoubleNode temp = head;
        int count = 0;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void add(DoubleNode node) {
        DoubleNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre=temp;
    }

    public void remove(DoubleNode node) {
        DoubleNode temp = head;
        while (temp.next != null) {
            if (temp.data == node.data) {
                break;
            }
            temp = temp.next;
        }
        temp.pre.next = temp.next;
        if(temp.next != null) {
            temp.next.pre = temp.pre;
        }
    }

    public void listNode() {
        DoubleNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }
}
