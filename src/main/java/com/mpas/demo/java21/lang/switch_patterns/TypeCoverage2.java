package com.mpas.demo.java21.lang.switch_patterns;

public class TypeCoverage2 {

    sealed interface I<T> permits A, B {}
    final class A<X> implements I<String> {}
    final class B<Y> implements I<Y> {}

    static int testGenericSealedExhaustive(I<Integer> i) {
        return switch (i) {
            // Exhaustive as no A case possible!
            case B<Integer> bi -> 42;
        };
    }
}
