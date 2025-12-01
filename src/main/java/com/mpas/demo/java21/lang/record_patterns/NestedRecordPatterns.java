package com.mpas.demo.java21.lang.record_patterns;

public class NestedRecordPatterns {

    enum Color { RED, GREEN, BLUE }
    record ColoredPoint(Point p, Color c) {}
    record ColoredRectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}

    static void printXCoordOfUpperLeftPointWithPatterns(ColoredRectangle r) {
        if (r instanceof ColoredRectangle(
                ColoredPoint(Point(var x, var y), var upperLeftColor),
                var lowerRightCorner)) {
            System.out.println("Upper-left corner: " + x);
        }
    }

    static void nestedBox(Box<Box<String>> bo) {
        // Box(Box(var s)) is inferred to be Box<Box<String>>(Box(var s))
        if (bo instanceof Box(Box(var s))) {
            System.out.println("String " + s);
        }
    }
}
