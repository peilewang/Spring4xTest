package com.peilw.child.algorithm.links;

public class SingleLink {
    public static void main(String[] args) {
        SingleLink singleLink = new SingleLink();
        Node node = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(2);
        Node node5 = new Node(5);
        singleLink.add(node);
        singleLink.add(node2);
        singleLink.add(node3);
       // System.out.println(">>>>>>>>删除前");
        singleLink.listNode();
       // singleLink.ReverseInsert(singleLink.head);
        System.out.println();
        singleLink.insert(node4);
        singleLink.insert(node5);
        singleLink.listNode();
        /*System.out.println(">>>>>>>>删除后");
        singleLink.remove(node);
        singleLink.listNode();*/

    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    private Node head = new Node();

    public int size() {
        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void add(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void remove(Node node) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == node.data) {
                break;
            }
            temp = temp.next;

        }
        temp.next = temp.next.next;
    }

    public void listNode() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public Node reverse() {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur.next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public void insert(Node node){
        Node temp=head;
        int count=1;
        while(temp.next!=null){
            temp=temp.next;
            count++;
            if(count==(int)node.data){
               break;
            }
        }
        node.next=temp.next;
        temp.next=node;
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

}
