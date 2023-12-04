package com.mpas.demo.java21.lang.switch_patterns;

//
//sealed interface Seal permits A, B, C {
//    static Seal getAValue() {
//        return new A();
//    }
//}
//final class A implements Seal {}
//final class B implements Seal {}
//final class C implements Seal {}
// However, suppose you edit Seal as follows and compile this class and not ME:
// When you run ME, it throws a MatchException:
// Exception in thread "main" java.lang.MatchException
//            at ME.main(ME.java:3)
//
sealed interface Seal permits A, B {
    static Seal getAValue() {
        return new A();
    }
}
final class A implements Seal {}
final class B implements Seal {}
class ME {
    public static void main(String[] args) {
        System.out.println(switch (Seal.getAValue()) {
            case A a -> 1;
            case B b -> 2;
        });
    }
}
