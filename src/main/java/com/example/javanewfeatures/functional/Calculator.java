package com.example.javanewfeatures.functional;

import java.util.function.Function;

public class Calculator {

    public static Integer add(RequestDto request) {
        Function<RequestDto,Integer> addUp= dto -> dto.getNum1() + dto.getNum2();
        return addUp.apply(request);
    }
}
