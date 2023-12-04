package com.mpas.demo.java21.lang.switch_patterns;

public class TypeCoverage4 {

    record Pair<T>(T x, T y) {}
    sealed interface I permits C, D {}
    record C(String s) implements I {}
    record D(String s) implements I {}

    static void exhaustiveSwitch(Pair<I> p) {
        switch (p) {
            case Pair<I>(I i, C c) -> System.out.println("C = " + c.s());
            case Pair<I>(I i, D d) -> System.out.println("D = " + d.s());
        }
    }
}
