package com.example.javanewfeatures.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntroStreamDemo {
    public static void main(String[] args) {
        List<String> departmentList = Arrays.asList("HR","Sales","Supplier","Counter");

        Stream<String> normalStream= departmentList.stream();
        normalStream.forEach(System.out ::println);

        Stream<String> ownStream = Stream.of("Sales","Supplier","HR");
        ownStream.forEach(System.out ::println);

        Stream<String> parallelStream= departmentList.parallelStream();
        parallelStream.forEach(System.out ::println);



    }
}
