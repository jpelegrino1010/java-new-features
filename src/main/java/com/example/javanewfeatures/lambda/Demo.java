package com.example.javanewfeatures.lambda;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        voidMethodWithNoParams();
        voidMethodWithOneParam("Method with one parameter");
        voidMethodWithTwoParams();
        System.out.println(returnMethodWithTwoParam());

        List<String> colors= Arrays.asList("Red","Blue","Green");
        System.out.println(colors);

        colors.sort((s1,s2)-> s1.compareTo(s2));
        System.out.println("After");
        System.out.println(colors);


    }

    private static void voidMethodWithNoParams() {
        FunctionalWithNoArg method = () -> System.out.println("Method with no rueturn input params");

        method.printHello();
    }

    private static void voidMethodWithOneParam(String param) {
        VoidMethodWithOneParam method = p1 -> System.out.println(p1);

        method.printInput(param);
    }

    private static void voidMethodWithTwoParams() {
        VoidMethodWithTwoParam method = (param1, param2) -> System.out.println(param1 + param2);

        method.calculateAndPrint(2,5);
    }

    private static double returnMethodWithTwoParam() {
        ReturnMethodWithTwoParam method = (p1, p2) -> p1 * p2;

        return method.calculate(25,5);
    }
}
