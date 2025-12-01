package com.mpas.demo.java22;

record Point(int x, int y) {}

public class Unnamed1 {

	public static void main(String[] args) {
		Point p = new Point(3, 0);
		String description = switch (p) {
			case Point(var x, var y) when x == 0 && y == 0 -> "origin";
			case Point(var x, var _) when x == 0 -> "on y-axis";
			case Point(var _, var y) when y == 0 -> "on x-axis";
			case Point(var _, var _) -> "somewhere else";
		};
		System.out.println(description);

		description = switch (p) {
			case Point(var x, var y) when x == 0 && y == 0 -> "origin";
			case Point(var x, _) when x == 0 -> "on y-axis";
			case Point(_, var y) when y == 0 -> "on x-axis";
			case Point(_, _) -> "somewhere else";
			// Weirdly, in build 21-ea+24-2086, the following line is necessary
			default -> throw new MatchException("This can't happen", null);
		};
		System.out.println(description);

		if (p instanceof Point(var x, var y) && x == 0 && y == 0) System.out.println("origin");
		else if (p instanceof Point(var x, _) && x == 0) System.out.println("on y-axis");
		else if (p instanceof Point(_, var y) && y == 0) System.out.println("on x-axis");
		else if (p instanceof Point) System.out.println("somewhere else");
	}
}
