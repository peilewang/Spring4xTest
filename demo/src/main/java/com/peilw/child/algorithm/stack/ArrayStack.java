package com.peilw.child.algorithm.stack;

public class ArrayStack {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.list();
        System.out.println("出栈");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println("peek--begin");
        System.out.println(arrayStack.peek());
        System.out.println("peek--end");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        arrayStack.list();
    }

    private int top = -1;
    private int maxSize;
    private Object[] objects;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        objects = new Object[maxSize - 1];
    }

    public void push(Object object) {
        if (isFull()) {
            System.out.println("栈满");
        }
        objects[++top] = object;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            throw new RuntimeException("栈空，没有数据");
        }
        Object value = objects[top];
        objects[top] = null;
        top--;
        return value;
    }

    public Object peek() {
        return objects[top];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(objects[i]);
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}
