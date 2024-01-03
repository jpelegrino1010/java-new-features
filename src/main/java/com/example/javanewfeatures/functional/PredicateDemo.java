package com.example.javanewfeatures.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {

    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,14);

//        PREDICATE
        Predicate<Integer> isEven = n -> n%2 == 0;
        System.out.println(list.stream().filter(isEven).collect(Collectors.toList()));
    }
}
