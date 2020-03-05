package com.peilw.child.java8.function.skills;

import lombok.Data;

@Data
public class TreeProcessor {
    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    private String k;

    public static int lookup(String k, int defaultval, Tree t) {
        if (t == null) return defaultval;
        if (k.equals(t.key)) return t.val;
        return lookup(k, defaultval, k.compareTo(t.key) < 0 ? t.left : t.right);
    }
}
