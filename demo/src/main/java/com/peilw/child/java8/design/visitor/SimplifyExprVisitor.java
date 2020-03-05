package com.peilw.child.java8.design.visitor;

public class SimplifyExprVisitor {
    public Expr visit(BinOp e) {
        if ("+".equals(e.opname) && e.right instanceof Number){
            return e.left;
        }
        return e;
    }
}
