package com.mpas.demo.java21.lang.switch_patterns;

public class TypeCoverage3 {

    record Pair<T>(T x, T y) {}
    class A {}
    class B extends A {}

//    static void notExhaustive(Pair<A> p) {
//        switch (p) {
//            // error: the switch statement does not cover all possible input values
//            case Pair<A>(A a, B b) -> System.out.println("Pair<A>(A a, B b)");
//            case Pair<A>(B b, A a) -> System.out.println("Pair<A>(B b, A a)");
//        }
//    }

}
