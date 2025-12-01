package com.mpas.demo.java21.lang.switch_patterns;

public class InferenceOfTypeArgument {

    record MyPair<T, U>(T x, U y) { }

    static void recordInference(MyPair<String, Integer> p){
        switch (p) {
            case MyPair(var s, var i) ->
                    System.out.println(s + ", #" + i);
        }
    }
}
