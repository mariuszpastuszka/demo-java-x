package com.mpas.demo.java21.lang.switch_patterns;

public class SelectorExpressionType {

    record Point(int x, int y) { }
    enum Color { RED, GREEN, BLUE; }
    static void typeTester(Object obj) {
        switch (obj) {
            case null     -> System.out.println("null");
            case String s -> System.out.println("String");
            case Color c  -> System.out.println("Color with " + c.values().length + " values");
            case Point p  -> System.out.println("Record class: " + p.toString());
            case int[] ia -> System.out.println("Array of int values of length" + ia.length);
            default       -> System.out.println("Something else");
        }
    }
}
