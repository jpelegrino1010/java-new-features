package com.example.javanewfeatures.times;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate today= LocalDate.now();
        LocalDate myBirthday= LocalDate.of(1980,11,25);
        int year = myBirthday.getYear();

        LocalDate parseDate= LocalDate.parse("2023-11-25");

        int year1= myBirthday.get(ChronoField.YEAR);

        System.out.println(today);
        System.out.println(myBirthday);
        System.out.println(year);
        System.out.println(year1);
        System.out.println(parseDate);

    }
}
