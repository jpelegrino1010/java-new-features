package com.example.javanewfeatures.lambda;

@FunctionalInterface
public interface ReturnMethodWithTwoParam {
    double calculate(int p1,int p2);

    private void printHello() {
        System.out.println("Hello");
    }

    default void sayHello() {
        printHello();
    }
}
