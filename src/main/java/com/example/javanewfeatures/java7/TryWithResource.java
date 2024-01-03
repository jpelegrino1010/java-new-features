package com.example.javanewfeatures.java7;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;


public class TryWithResource {

    public static void main(String[] args) throws IOException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try(InputStream inputStream=classloader.getResourceAsStream("file.txt")) {
            System.out.println(inputStream);
        }
    }
}
