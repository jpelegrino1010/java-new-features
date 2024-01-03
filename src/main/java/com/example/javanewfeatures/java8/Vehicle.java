package com.example.javanewfeatures.java8;

public interface Vehicle {

    void applyBreak();
     default void autoPilot() {
        System.out.println("Honda Auto pilot Applied");
    }

     static void sayHello() {
        System.out.println("Say hello!!");
    }
}
