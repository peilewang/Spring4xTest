package com.peilw.child.mydesign.strategy.enum_strategy;

public enum  CalCulator {
    Add("+"){
        public int exec(int a,int b){
            return a+b;
        }
    },
    SUB("-"){
        public int exec(int a,int b){
            return a-b;
        }

    };
    String value="";
    private CalCulator(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
    public abstract int exec(int a,int b);
}
