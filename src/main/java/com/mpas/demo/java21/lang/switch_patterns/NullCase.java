package com.mpas.demo.java21.lang.switch_patterns;

public class NullCase {

    static void test(Object obj) {
        switch (obj) {
            case null     -> System.out.println("null!");
            case String s -> System.out.println("String");
            default       -> System.out.println("Something else");
        }
    }

//    static void testStringOrNull(Object obj) {
//        switch (obj) {
//            // error: invalid case label combination
//            case null, String s -> System.out.println("String: " + s);
//            default             -> System.out.println("Something else");
//        }
//    }

    static void testStringOrNull(Object obj) {
        switch (obj) {
            case String s       -> System.out.println("String: " + s);
            case null, default  -> System.out.println("null or not a string");
        }
    }

//    String s = null;
//        switch (s) {
//        case Object obj -> System.out.println("This doesn't match null");
//        // No null label; NullPointerException is thrown
//        // if s is null
//    }
}
