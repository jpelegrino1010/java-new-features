package com.example.javanewfeatures.methodreferences;

import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Demo.staticMethodReference();
        Demo.instanceMethodReference();
        Demo.instanceMethodWithClassName();
        Demo.classMethodReference();
    }

// Static Reference
    public static void staticMethodReference() {

        AritmeticOperation operation = (a, b) -> {
            int sum= a +b;
            System.out.println("printing the sum:: "+ sum);

            return sum;
        };

        operation.performOperation(2,4);

        AritmeticOperation methodRef = Demo::performAddition;
        methodRef.performOperation(6,11);
    }

    public static  int performAddition(int a, int b) {
        int sum = a + b * 3;
        System.out.println("result "+ sum);

        return sum;
    }

    public static void instanceMethodReference() {
        AritmeticOperation operation = (a, b) -> {
            int sum= a +b;
            System.out.println("INSTANCE the sum:: "+ sum);

            return sum;
        };

        operation.performOperation(2,4);

        Demo methodRef=new Demo();
        AritmeticOperation instanceMethod = methodRef ::performInstanceAddition;
        instanceMethod.performOperation(2,3);

    }

    public int performInstanceAddition(int a, int b) {
        int sum = a + b * 3;
        System.out.println("result 2"+ sum);

        return sum;
    }


    public static void instanceMethodWithClassName() {
        List<String> list= Arrays.asList("Juan","Pedro","Maria");

        list.forEach(s -> System.out.println(s));
        System.out.println("*******************************************");

        list.forEach(System.out ::println);
    }

    public static void classMethodReference() {
        ProductInterface productInterface = (name, price) -> new Product(name,price);
        Product product=productInterface.getProduct("Samsung",2511);
        System.out.println(product.toString());


        ProductInterface classRef = Product::new;
        Product product1= classRef.getProduct("Apple", 3500);
        System.out.println(product1.toString());
    }
}
