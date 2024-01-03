package com.example.javanewfeatures.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethodDemo {

    public static void main(String[] args) {
//       mapMethod();
//       flatMapMethod();
//        limitMethod();
//        skipMethod();
//        peakMethod();
//        sortedMethod();
//        distinctMethod();
//        reduceMethod();
//        collectMethod();
//        collectAndThen();
        partitioning();
    }

    public static void mapMethod() {
        List<Employee> employees= Arrays.asList(new Employee("Juan",25000,"jmartinez@gmail.com"),
                new Employee("Maria",10500,"maria@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Angel",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
        new Employee("Pedro",33000,"pedro@gmail.com"),
        new Employee("Pedro",33000,"pedro@gmail.com"));

        employees.stream().map(employee -> employee.getName() + " "+ employee.getSalary()).forEach(System.out ::println);

        employees.stream().map(employee -> {
            double salary=employee.getSalary();
            if(salary>20000) {
                salary=salary +(salary*0.18);
            }
            return employee.getName() + " "+ salary;
        }).forEach(System.out ::println);
    }

    public static void flatMapMethod() {
        String [] arrOfWords = {"Black","White"};

        Stream<String> stream=Arrays.stream(arrOfWords);
        stream.map(word -> word.split(""))
                .flatMap(Arrays :: stream).forEach(System.out ::println);
    }

    public static void limitMethod() {
        Stream.generate(new Random() :: nextInt).limit(3).forEach(System.out ::println);
    }

    public static void skipMethod() {
        Stream.iterate(1,n -> n + 1).skip(10).limit(5).forEach(System.out ::println);
    }

    public static void peakMethod() {
        List<Employee> employees= Arrays.asList(new Employee("Juan",25000,"jmartinez@gmail.com"),
                new Employee("Maria",10500,"maria@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"));

        employees.stream().map(emp -> emp.getName().toUpperCase()).peek(n -> System.out.println("The value es "+ n))
                .forEach(System.out ::println);
    }

    public static void sortedMethod() {
        List<Employee> employees= Arrays.asList(new Employee("Juan",25000,"jmartinez@gmail.com"),
                new Employee("Maria",10500,"maria@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Angel",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"));

        employees.stream().sorted((a,b) -> a.getName().compareTo(b.getName())).forEach(System.out ::println);
    }

    public static void distinctMethod() {
        List<Employee> employees= Arrays.asList(new Employee("Juan",25000,"jmartinez@gmail.com"),
                new Employee("Maria",10500,"maria@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Angel",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"));

        employees.stream().distinct().forEach(System.out ::println);
    }

    public static void reduceMethod() {
        System.out.println(Stream.iterate(1,n -> n +1).limit(20).reduce(0,(a,b)-> a+b).intValue());
    }

    public static void collectMethod() {
        List<Employee> employees= Arrays.asList(new Employee("Juan",25000,"jmartinez@gmail.com"),
                new Employee("Maria",10500,"maria@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Angel",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"));

        List<Employee> employeeList=employees.stream().filter(emp -> emp.getName().equals("Pedro")).collect(Collectors.toList());

        employeeList.forEach(System.out ::println);

        Map<String,List<Employee>> employeeMap= employees.stream().collect(Collectors.groupingBy(Employee::getName));

        System.out.println(employeeMap);
    }

    public static void collectAndThen() {
        List<Employee> employees= Arrays.asList(new Employee("Juan",25000,"jmartinez@gmail.com"),
                new Employee("Maria",10500,"maria@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Angel",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"));

        String emailEmployee = employees.stream().collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee ::getSalary)
        ), (Optional<Employee> employee) -> employee.isPresent() ? employee.get().getEmail() : "None"));

        System.out.println(emailEmployee);
    }


    public static void partitioning() {
        List<Employee> employees= Arrays.asList(new Employee("Juan",25000,"jmartinez@gmail.com"),
                new Employee("Maria",10500,"maria@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"),
                new Employee("Angel",33000,"pedro@gmail.com"),
                new Employee("Pedro",33000,"pedro@gmail.com"));

        Map<Boolean,List<Employee>> partitioning= employees.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary()>20000));

        System.out.println(partitioning);
    }

}
