package com.peilw.child.algorithm.tree;

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node("宋江", 1);
        Node node = new Node("吴用", 2);
        Node node2 = new Node("卢俊义", 3);
        Node node3 = new Node("林冲", 4);
        root.left = node;
        root.right = node2;
        node2.right = node3;
        System.out.println("》》》》》》》前序遍历");
        root.preOrder();
        System.out.println("》》》》》》》中序遍历");
        root.midOrder();
        System.out.println("》》》》》》》后序遍历");
        root.postOrder();
    }

    static class Node {
        public Node left;
        public Node right;
        private String name;
        private int no;

        public Node(String name, int no) {
            this.name = name;
            this.no = no;
        }

        @Override
        public String toString() {
            return "Node{" + "name='" + name + '\'' + ", no=" + no + '}';
        }

        //前序遍历
        public void preOrder() {
            System.out.println(this);//先输出父节点
            //递归左子树遍历
            if (this.left != null) {
                this.left.preOrder();
            }
            //递归右子树遍历
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        //中序遍历
        public void midOrder() {
            if (this.left != null) {
                this.left.midOrder();
            }
            System.out.println(this);
            if (this.right != null) {
                this.right.midOrder();
            }
        }

        //后续遍历
        public void postOrder() {
            if (this.left != null) {
                this.left.midOrder();
            }
            if (this.right != null) {
                this.right.midOrder();
            }
            System.out.println(this);
        }

        //前序查找
        public Node preOrderFind(int no) {
            if (this.no == no) {
                return this;
            }
            Node resNode = null;
            if (this.left != null) {
                resNode = this.left.preOrderFind(no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (this.right != null) {
                resNode = this.right.preOrderFind(no);
            }
            return resNode;
        }

        //中序查找
        public Node midOrderFind(int no) {
            Node resNode = null;
            if (this.left != null) {
                resNode = this.left.preOrderFind(no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (this.no == no) {
                return this;
            }
            if (this.right != null) {
                resNode = this.right.preOrderFind(no);
            }
            return resNode;
        }

        //后序查找
        public Node postOrderFind(int no) {
            Node resNode = null;
            if (this.left != null) {
                resNode = this.left.preOrderFind(no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (this.right != null) {
                resNode = this.right.preOrderFind(no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (this.no == no) {
                return this;
            }
            return resNode;
        }
    }
}
