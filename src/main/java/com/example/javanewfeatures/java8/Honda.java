package com.example.javanewfeatures.java8;

public class Honda implements Vehicle{
    @Override
    public void applyBreak() {
        System.out.println("breaking down");
    }


    public static void main(String[] args) {
        Vehicle.sayHello();
    }
}
