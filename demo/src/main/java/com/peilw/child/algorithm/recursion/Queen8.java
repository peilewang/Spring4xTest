package com.peilw.child.algorithm.recursion;

public class Queen8 {
    public static int count;
    int[] a = new int[8];

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("一共有： " + count + "种");
    }

    private void check(int n) {
        if (n == 8) {
            print();
            return;
        }
        for (int i = 0; i < 8; i++) {
            a[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //同一列或者斜线
            if (a[n] == a[i] || Math.abs(n - i) == Math.abs(a[n] - a[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int b : a) {
            System.out.print(b + "  ");
        }
        System.out.println();
    }
}
