package com.mpas.demo.java21.lang.switch_patterns;

public class QualifiedEnums2 {

    sealed interface CardClassification permits Standard, Tarot {}
    public enum Standard implements CardClassification
    { SPADE, HEART, DIAMOND, CLUB }
    public enum Tarot implements CardClassification
    { SPADE, HEART, DIAMOND, CLUB, TRUMP, EXCUSE }

    static void determineSuit(CardClassification c) {
        switch (c) {
            case Standard s when s == Standard.SPADE    -> System.out.println("Spades");
            case Standard s when s == Standard.HEART    -> System.out.println("Hearts");
            case Standard s when s == Standard.DIAMOND  -> System.out.println("Diamonds");
            case Standard s                             -> System.out.println("Clubs");
            case Tarot t when t == Tarot.SPADE          -> System.out.println("Spades or Piques");
            case Tarot t when t == Tarot.HEART          -> System.out.println("Hearts or C\u0153ur");
            case Tarot t when t == Tarot.DIAMOND        -> System.out.println("Diamonds or Carreaux");
            case Tarot t when t == Tarot.CLUB           -> System.out.println("Clubs or Trefles");
            case Tarot t when t == Tarot.TRUMP          -> System.out.println("Trumps or Atouts");
            case Tarot t                                -> System.out.println("The Fool or L'Excuse");
        }
    }

    static void determineSuitQualifiedNames(CardClassification c) {
        switch (c) {
            case Standard.SPADE   -> System.out.println("Spades");
            case Standard.HEART   -> System.out.println("Hearts");
            case Standard.DIAMOND -> System.out.println("Diamonds");
            case Standard.CLUB    -> System.out.println("Clubs");
            case Tarot.SPADE      -> System.out.println("Spades or Piques");
            case Tarot.HEART      -> System.out.println("Hearts or C\u0153ur");
            case Tarot.DIAMOND    -> System.out.println("Diamonds or Carreaux");
            case Tarot.CLUB       -> System.out.println("Clubs or Trefles");
            case Tarot.TRUMP      -> System.out.println("Trumps or Atouts");
            case Tarot.EXCUSE     -> System.out.println("The Fool or L'Excuse");
        }
    }
}
