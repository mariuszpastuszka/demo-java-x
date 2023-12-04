package com.mpas.demo.java21.lang.switch_patterns;

public class PatternMatchingIntro {

    interface Shape { }
    record Rectangle(double length, double width) implements Shape { }
    record Circle(double radius) implements Shape { }
    public static double getPerimeter(Shape s) throws IllegalArgumentException {
        if (s instanceof Rectangle r) {
            return 2 * r.length() + 2 * r.width();
        } else if (s instanceof Circle c) {
            return 2 * c.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }

    public static double getPerimeter2(Shape s) throws IllegalArgumentException {
        return switch (s) {
            case Rectangle r -> 2 * r.length() + 2 * r.width();
            case Circle c    -> 2 * c.radius() * Math.PI;
            default          -> throw new IllegalArgumentException("Unrecognized shape");
        };
    }

    public static double getPerimeter3(Shape s) throws IllegalArgumentException {
        switch (s) {
            case Rectangle r: return 2 * r.length() + 2 * r.width();
            case Circle c:    return 2 * c.radius() * Math.PI;
            default:          throw new IllegalArgumentException("Unrecognized shape");
        }
    }
}
