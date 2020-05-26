package com.peilw.child.algorithm.stack;

public class OperationsStackDemo {
    public static void main(String[] args) {
        OperationsStackDemo operationsStackDemo = new OperationsStackDemo();
        String oper = "20*4+5-10/2";
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        int index = 0;
        String num = "";
        while (index < oper.length()) {
            char ch = oper.charAt(index);
            if (operationsStackDemo.isOper(ch)) {
                if (operStack.isEmpty() || operationsStackDemo.priority((char) operStack.peek()) < operationsStackDemo.priority(ch)) {
                    operStack.push(ch);
                } else {
                    int cal = operationsStackDemo.cal((int) numStack.pop(), (int) numStack.pop(), (char) operStack.pop());
                    numStack.push(cal);
                    operStack.push(ch);
                }
            } else {
                num += ch;
                if (index == oper.length() - 1) {
                    numStack.push(Integer.parseInt(num));
                } else {
                    if (operationsStackDemo.isOper(oper.charAt(index + 1))) {
                        numStack.push(Integer.parseInt(num));
                        num = "";
                    }
                }
            }
            index++;
        }
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            int cal = operationsStackDemo.cal((int) numStack.pop(), (int) numStack.pop(), (char) operStack.pop());
            numStack.push(cal);
        }
        System.out.println(">>>>>>>处理结果为： " + numStack.pop());

    }

    public int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        }
        return -1;
    }

    public boolean isOper(char oper) {
        return oper == '*' || oper == '/' || oper == '+' || oper == '-';
    }

    public int cal(int num1, int num2, char oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
            default:
                return 0;
        }
    }
}
