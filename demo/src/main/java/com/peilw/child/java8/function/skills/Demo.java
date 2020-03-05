package com.peilw.child.java8.function.skills;

public class Demo {
    public static void main(String[] args) {

    }

    static TrainJourney link(TrainJourney a, TrainJourney b) {
        if (a == null) return b;
        TrainJourney t = a;
        while (t.onward != null) {
            t = t.onward;
        }
        t.onward = b;
        return a;
    }

    static TrainJourney append(TrainJourney a, TrainJourney b) {
        return a == null ? b : new TrainJourney(a.price, append(a.onward, b));
    }
    public static void update(String k, int newval, Tree t) {
        if (t == null) { /* 应增加一个新的节点 */ }
        else if (k.equals(t.key)) t.val = newval;
        else update(k, newval, k.compareTo(t.key) < 0 ? t.left : t.right);
    }
    public static Tree fupdate(String k, int newval, Tree t) {
        return (t == null) ?
                new Tree(k, newval, null, null) :
                k.equals(t.key) ?
                        new Tree(k, newval, t.left, t.right) :
                        k.compareTo(t.key) < 0 ?
                                new Tree(t.key, t.val, fupdate(k,newval, t.left), t.right) :
                                new Tree(t.key, t.val, t.left, fupdate(k,newval, t.right));
    }
}
