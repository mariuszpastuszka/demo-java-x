package com.mpas.demo.java21.lang.switch_patterns;

public class TypeCoverage {

//    static int coverage(Object obj) {
//        return switch (obj) {         // Error - not exhaustive
//            case String s  -> s.length();
//            case Integer i -> i;
//        };
//    }

    static int coverage(Object obj) {
        return switch (obj) {
            case String s  -> s.length();
            case Integer i -> i;
            default        -> 0;
        };
    }

    sealed interface S permits A, B, C { }
    final class A implements S { }
    final class B implements S { }
    record C(int i) implements S { }  // Implicitly final
    static int testSealedCoverage(S s) {
        return switch (s) {
            case A a -> 1;
            case B b -> 2;
            case C c -> 3;
        };
    }
}
