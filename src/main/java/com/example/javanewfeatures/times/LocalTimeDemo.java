package com.example.javanewfeatures.times;

import java.time.LocalTime;

public class LocalTimeDemo {

    public static void main(String[] args) {
        LocalTime time= LocalTime.now();
        LocalTime parseTime= LocalTime.parse("12:00");

        System.out.println(time);
        System.out.println(parseTime);
    }
}
