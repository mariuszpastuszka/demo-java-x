package com.mpas.demo.java21.lang.record_patterns;

sealed interface JSONValue {}
sealed interface JSONPrimitive<T> extends JSONValue {}
record JSONNumber(double value) implements JSONPrimitive<Double> {}
record JSONBoolean(boolean value) implements JSONPrimitive<Boolean> {}
record JSONString(String value) implements JSONPrimitive<String> {}

record Pair<T>(T left, T right) {
	public static <U> Pair<U> of(U left, U right) { return new Pair<U>(left, right); }
}

public class Main3 {
	public static <T> double toNumber(JSONPrimitive<T> v) {
		return switch (v) {
			case JSONNumber(var n) -> n;
			case JSONBoolean(var b) -> b ? 1 : 0;
			case JSONString(var s) -> {
				try {
					yield Double.parseDouble(s);
				} catch (NumberFormatException __) {
					yield Double.NaN;
				}
			}
		};
	}

	public static Object sum1(Pair<? extends JSONPrimitive<?>> pair) {
		return switch (pair) {
			case Pair(JSONNumber(var left), JSONNumber(var right)) -> left + right;
			case Pair(JSONBoolean(var left), JSONBoolean(var right)) -> left | right;
			case Pair(JSONString(var left), JSONString(var right)) -> left.concat(right);
			// Compiler correctly detects that the switch is not exhaustive
			// Comment out the following line to verify
			default -> null;
		};
	}

	public static <T extends JSONPrimitive<U>, U> Object sum2(Pair<T> pair) {
		return switch (pair) {
			case Pair(JSONNumber(var left), JSONNumber(var right)) -> left + right;
			case Pair(JSONBoolean(var left), JSONBoolean(var right)) -> left | right;
			case Pair(JSONString(var left), JSONString(var right)) -> left.concat(right);
			default -> throw new AssertionError(); // Sadly Java can't tell this won't happen
		};
	}

   /*
   public static <T extends JSONPrimitive<U>, U> Object sum3(Pair<T> pair) {
      return switch (pair) {
         // Error—these generic types do not match Pair<T>
         case Pair<JSONNumber>(JSONNumber(var left), JSONNumber(var right)) -> left + right;
         case Pair<JSONBoolean>(JSONBoolean(var left), JSONBoolean(var right)) -> left | right;
         case Pair<JSONString>(JSONString(var left), JSONString(var right)) -> left.concat(right);
      };
   }
   */


	public static void main(String[] args) {
		System.out.println(toNumber(new JSONString("42")));
		System.out.println(sum2(Pair.of(new JSONNumber(29), new JSONNumber(13))));
		// This won't compile, and it shouldn't
		// System.out.println(sum2(Pair.of(new JSONNumber(29), new JSONString("13"))));
	}
}
