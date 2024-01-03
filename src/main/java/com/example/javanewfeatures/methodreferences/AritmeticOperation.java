package com.example.javanewfeatures.methodreferences;

@FunctionalInterface
public interface AritmeticOperation {

    int performOperation(int a, int b);

    default void performAdd(int a, int b) {
        int res= addTwoNum(a,b);
        printTheInput(res);
    }

    private int addTwoNum(int a, int b) {
        return a + b;
    }

    static void printTheInput(int res) {
        System.out.println(res);
    }
}
