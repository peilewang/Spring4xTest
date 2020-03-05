package com.peilw.child.java8.function;

import java.util.function.DoubleUnaryOperator;

public class Demo {
    public static void main(String[] args){
        DoubleUnaryOperator convertCtoF = curriedConverter(9.0/5, 32);
        DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
        DoubleUnaryOperator convertKmtoMi = curriedConverter(0.6214, 0);
        double gbp = convertUSDtoGBP.applyAsDouble(1000);
    }
    static DoubleUnaryOperator curriedConverter(double f, double b){
        return (double x) -> x * f + b;
    }
}
