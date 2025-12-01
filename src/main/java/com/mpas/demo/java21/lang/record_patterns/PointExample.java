package com.mpas.demo.java21.lang.record_patterns;

class PointExample {
    static void printAngleFromXAxis(Object obj) {
        if (obj instanceof Point(double x, double y)) {
            System.out.println(Math.toDegrees(Math.atan2(y, x)));
        }
    }

    static void printAngleFromXAxisTypePattern(Object obj) {
        if (obj instanceof Point p) {
            System.out.println(Math.toDegrees(Math.atan2(p.y(), p.x())));
        }
    }
}
