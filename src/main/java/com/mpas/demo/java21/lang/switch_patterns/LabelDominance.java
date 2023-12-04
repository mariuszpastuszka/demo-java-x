package com.mpas.demo.java21.lang.switch_patterns;

public class LabelDominance {

    static void error(Object obj) {
        switch(obj) {
            case CharSequence cs ->
                    System.out.println("A sequence of length " + cs.length());
//            case String s -> // error: this case label is dominated by a preceding case label
//                    System.out.println("A string: " + s);
            default -> { break; }
        }
    }

    static void error2(Integer value) {
        switch(value) {
            case Integer i ->
                    System.out.println("Integer: " + i);
//            case -1, 1 -> // Compile-time errors for both cases -1 and 1:
                // this case label is dominated by a preceding case label
//                    System.out.println("The number 42");
//            default -> { break; }
        }
    }

    enum Color { RED, GREEN, BLUE; }

    static void error3(Color value) {
        switch(value) {
            case Color c ->
                    System.out.println("Color: " + c);
//            case RED -> // error: this case label is dominated by a preceding case label
//                    System.out.println("The color red");
        }
    }

    static void testInteger(Integer value) {
        switch(value) {
            case Integer i when i > 0 ->
                    System.out.println("Positive integer");
            case 1 ->
                    System.out.println("Value is 1");
            case -1 ->
                    System.out.println("Value is -1");
            case Integer i ->
                    System.out.println("An integer");
        }
    }

    static void testIntegerBetter(Integer value) {
        switch(value) {
            case 1 ->
                    System.out.println("Value is 1");
            case -1 ->
                    System.out.println("Value is -1");
            case Integer i when i > 0 ->
                    System.out.println("Positive integer");
            case Integer i ->
                    System.out.println("An integer");
        }
    }
}
