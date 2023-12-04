package com.mpas.demo.java21.lang.record_patterns;

public class BoxExample {

    static void printBoxContents(Box<String> bo) {
        if (bo instanceof Box<String>(String s)) {
            System.out.println("Box contains: " + s);
        }
    }

    static void uncheckedConversion(Box bo) {
        // error: Box cannot be safely cast to Box<String>
//        if (bo instanceof Box<String>(var s)) {
//            System.out.println("String " + s);
//        }
    }

    static void printAngleFromXAxis(Object obj) {
        if (obj instanceof Point(var x, var y)) {
            System.out.println(Math.toDegrees(Math.atan2(y, x)));
        }
    }

    static void printBoxContentsAgain(Box<String> bo) {
        if (bo instanceof Box(var s)) {
            System.out.println("Box contains: " + s);
        }
    }
}
