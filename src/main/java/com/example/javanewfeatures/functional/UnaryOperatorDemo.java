package com.example.javanewfeatures.functional;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {

    public static void main(String[] args) {

        Function<String,String> convertStr = str -> str.toUpperCase();
        System.out.println(convertStr.apply("hello world"));

        Function<Integer,Integer> multiplyOperation = a -> {
            System.out.println("Double value");
            return a *2;
        };

        UnaryOperator<Integer> threeOperation = a -> a * 3;
        System.out.println(multiplyOperation.apply(5));

        Function<Integer,Integer> divOperation = a -> a/2;

        divOperation= divOperation.compose(a -> a/3);

        System.out.println(divOperation.apply(30));

        System.out.println(Calculator.add(new RequestDto(5,9)));;

    }
}
