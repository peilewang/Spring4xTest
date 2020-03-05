package com.peilw.child.java8.design.visitor;

import lombok.Data;

@Data
public class BinOp extends Expr{
    public String opname;
    public Expr left;
    public Integer right;
    public Expr accept(SimplifyExprVisitor v){
        return v.visit(this);
    }
}
