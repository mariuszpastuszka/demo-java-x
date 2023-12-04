package com.mpas.demo.java21.lang.switch_patterns;

public class QualifiedEnums {

    public enum Standard { SPADE, HEART, DIAMOND, CLUB }

    static void determineSuitStandardDeck(Standard d) {
        switch (d) {
            case SPADE   -> System.out.println("Spades");
            case HEART   -> System.out.println("Hearts");
            case DIAMOND -> System.out.println("Diamonds");
            default      -> System.out.println("Clubs");
        }
    }
}
