package com.mpas.demo.java22;

record Box<T>(T value) {}

public class Unnamed2 {

	public static void main(String[] args) {
		Object obj = Double.valueOf(3.14);
		String description = switch (obj) {
			case Double _, Float _ -> "a floating-point number";
			default -> "something other than a floating-point number";
		};
		System.out.println(description);

		Box<Number> box = new Box(Integer.valueOf(42));
		// box = new Box(null);
		// box = null;
		description = switch (box) {
			case Box(Float _), Box(Double _) -> "a boxed floating-point number";
			case Box(_) -> "something other than a floating-point number in this box";
		};
		System.out.println(description);
	}
}
