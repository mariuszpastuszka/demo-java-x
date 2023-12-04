package com.mpas.demo.java21.lang.switch_patterns;

public class WhenClauses {

    static void test(Object obj) {
        switch (obj) {
            case String s:
                if (s.length() == 1) {
                    System.out.println("Short: " + s);
                } else {
                    System.out.println(s);
                }
                break;
            default:
                System.out.println("Not a string");
        }
    }

    static void test2(Object obj) {
        switch (obj) {
            case String s when s.length() == 1 -> System.out.println("Short: " + s);
            case String s                      -> System.out.println(s);
            default                            -> System.out.println("Not a string");
        }
    }
}
