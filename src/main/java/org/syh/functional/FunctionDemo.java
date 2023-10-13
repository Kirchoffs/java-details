package org.syh.functional;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        calculateDemo();
        transformDemo();
    }

    private static void calculateDemo() {
        Function<Integer, Integer> doubleIt = num -> num * 2;
        Function<Integer, Integer> squareIt = num -> num * num;

        Function<Integer, Integer> doubleAndSquare = doubleIt.andThen(squareIt);

        int input = 6;
        int result = doubleAndSquare.apply(input);

        System.out.println("Calculate Demo:");
        System.out.println("Input: " + input);
        System.out.println("Result after double and square: " + result);
    }

    private static void transformDemo() {
        Function<Integer, String> integerToString = num -> num + "";
        Function<String, Integer> stringToInteger = str -> Integer.parseInt(str);

        Function<Integer, Integer> identity = integerToString.andThen(stringToInteger);

        int input = 6;
        int result = identity.apply(input);

        System.out.println("Transform Demo:");
        System.out.println("Input: " + input);
        System.out.println("Result after identity: " + result);
    }
}
