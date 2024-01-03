package com.example.javanewfeatures.functional;

import java.time.LocalDate;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Integer> dayOfTheMonth = () -> LocalDate.now().getDayOfMonth();
        System.out.println(dayOfTheMonth.get());

        Supplier<String> currDay = () -> LocalDate.now().getDayOfWeek().name();
        System.out.println(currDay.get());
    }
}
