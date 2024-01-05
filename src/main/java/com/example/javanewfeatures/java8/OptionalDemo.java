package com.example.javanewfeatures.java8;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        withJava8();
    }

    public static void withJava8() {
        String str []=new String[10];
        Optional<String> empty=Optional.empty();
        System.out.println(empty);

        str[4]="Los Muchachones";

        Optional<String> nullValue=Optional.ofNullable(str[4]);
        nullValue.ifPresent(System.out::println);

        System.out.println(nullValue.orElse("No value"));;

        empty.orElseThrow(NoSuchElementException::new);

        List<String> colors= Arrays.asList("Black","White","Red");

        Optional<List<String>> colorList=Optional.of(colors);



    }
}
