package com.example.javanewfeatures.functional;

import java.util.function.Consumer;

public class ConsumeDemo {

    public static void main(String[] args) {
        Consumer<String> convertAndDisplay = input -> System.out.println(input.toUpperCase());
        convertAndDisplay.accept("Hello World");

        Consumer<Integer> evenNumber = input -> ConsumeDemo.printEvenNumber(input);

        evenNumber.accept(100);
    }

    private static void printEvenNumber(int num) {
        for (int i=1;i<num;i++) {
            if(i%2==0)
                System.out.println(i);
        }
    }
}
