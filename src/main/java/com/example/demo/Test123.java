package com.example.demo;

import java.util.List;
import java.util.function.*;

public class Test123 {
    public static void main(String[] args){
        String y = new String("hello world");
        Predicate<String> pred = (x)-> "hello world" == x;
        Function<String, String> funcx = (x)-> "hello world" + x;
        Supplier<String> supplier = () -> "hello world";
        Consumer<String> consumer = x -> System.out.println(x);
        BinaryOperator<Integer> binaryOperator = (a,b)->a+b;
        binaryOperator.apply(1,2);
        UnaryOperator<Integer> unaryOperator = (a)->a+1;




    }
}

// predicate
// function
//supplier
//consumer
//Operator