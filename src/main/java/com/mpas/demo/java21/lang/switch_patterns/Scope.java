package com.mpas.demo.java21.lang.switch_patterns;

import com.mpas.demo.java17.lang.sealed.Circle;
import com.mpas.demo.java17.lang.sealed.Rectangle;
import com.mpas.demo.java17.lang.sealed.Shape;

public class Scope {

//    public static double getPerimeter(Shape shape) throws IllegalArgumentException {
//        if (shape instanceof Rectangle s) {
//            // You can use the pattern variable s of type Rectangle here.
//        } else if (shape instanceof Circle s) {
//            // You can use the pattern variable s of type Circle here
//            // but not the pattern variable s of type Rectangle.
//        } else {
//            // You cannot use either pattern variable here.
//        }
//    }

    static void test(Object obj) {
        switch (obj) {
            case Character c when c.charValue() == 7:
                System.out.println("Ding!");
                break;
            default:
                break;
        }
    }

    static void test2(Object obj) {
        switch (obj) {
            case Character c -> {
                if (c.charValue() == 7) {
                    System.out.println("Ding!");
                }
                System.out.println("Character, value " + c.charValue());
            }
            case Integer i ->
                    System.out.println("Integer: " + i);
            default -> {
                break;
            }
        }
    }

    static void test3(Object obj) {
        switch (obj) {
            case Character c:
                if (c.charValue() == 7) {
                    System.out.print("Ding ");
                }
                if (c.charValue() == 9) {
                    System.out.print("Tab ");
                }
                System.out.println("character, value " + c.charValue());
            default:
                // You cannot use the pattern variable c here:
                break;
        }
    }

//    static void test4(Object obj) {
//        switch (obj) {
//            case Character c:
//                if (c.charValue() == 7) {
//                    System.out.print("Ding ");
//                }
//                if (c.charValue() == 9) {
//                    System.out.print("Tab ");
//                }
//                System.out.println("character");
//            case Integer i:                 // Compile-time error
//                System.out.println("An integer " + i);
//            default:
//                System.out.println("Neither character nor integer");
//        }
//    }
}
