package com.peilw.child.algorithm.links;

public class CircleLink {
    private Node head = null;

    public static void main(String[] args) {
        CircleLink circleLink = new CircleLink();
        circleLink.add(5);
        circleLink.list();
        circleLink.countNode(2, 1, 5);
    }

    public void add(int number) {
        Node cur = null;
        for (int i = 1; i <= number; i++) {
            Node node = new Node(i);
            if (i == 1) {
                head = node;
                head.next = head;
                cur = node;
            } else {
                cur.next = node;
                node.next = head;
                cur = node;
            }
        }
    }

    public void list() {
        if (head == null) return;
        Node cur = head;
        while (true) {
            System.out.println(">>>>>" + cur.data);
            if (cur.next == head) {
                break;
            }
            cur = cur.next;
        }
    }

    //约瑟夫问题
    public void countNode(int startNo, int countNum, int nums) {
        Node last = head;
        while (true) {
            if (last.next == head) {
                break;
            }
            last = last.next;
        }
        for (int j = 0; j < startNo - 1; j++) {
            head = head.next;
            last = last.next;
        }
        while (true){
            if(last==head){
                break;
            }
            for(int j=0;j<countNum-1;j++){
                head = head.next;
                last = last.next;
            }
            System.out.println("出圈: "+head.data);
            head=head.next;
            last.next=head;
        }
        System.out.println("最后一个: "+head.data);

    }

}
