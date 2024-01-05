package com.example.javanewfeatures.times;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateAndTimeDemo {

    public static void main(String[] args) {
        LocalDate date= LocalDate.now();
        LocalTime time= LocalTime.now();

        LocalDateTime dateTime= LocalDateTime.of(date,time);

        System.out.println(dateTime);
        System.out.println(dateTime.toLocalDate());
        System.out.println(dateTime.toLocalTime());
        System.out.println(dateTime.plusDays(5));
        System.out.println(dateTime.minusDays(3));
    }
}
