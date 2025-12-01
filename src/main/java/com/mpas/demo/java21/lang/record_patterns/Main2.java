package com.mpas.demo.java21.lang.record_patterns;

public class Main2 {
	public static CharSequence simplify(SubSequence seq) {
		return switch (seq) {
			case Initial(var cs, var e) when e == cs.length() -> cs;
			case Final(var cs, var s) when s == 0 -> cs;
			case Middle(var cs, var s, var e) when s == 0 && e == cs.length() -> cs;
			case Initial(Initial(var cs, var e1), var e2) ->
					new Initial(cs, e2);
			case Initial(Middle(var cs, var s1, var e1), var e2) ->
					new Middle(cs, s1, s1 + e2);
			case Initial(Final(var cs, var s1), var e2) ->
					new Middle(cs, s1, s1 + e2);
			case Middle(Initial(var cs, var e1), var s2, var e2) ->
					new Middle(cs, s2, e2);
			case Middle(Middle(var cs, var s1, var e1), var s2, var e2) ->
					new Middle(cs, s1 + s2, s1 + e2);
			case Middle(Final(var cs, var s1), var s2, var e2) ->
					new Middle(cs, s1 + s2, s1 + e2);
			case Final(Initial(var cs, var e1), var s2) ->
					new Middle(cs, s2, e1);
			case Final(Middle(var cs, var s1, var e1), var s2) ->
					new Middle(cs, s1 + s2, e1);
			case Final(Final(var cs, var s1), var s2) ->
					new Final(cs, s1 + s2);
			default -> seq;
		};
	}

	public static void main(String[] args) {
		var result = simplify(new Final(
				new Initial("Mississippi", 6), 3));
		System.out.println(result + " " + result.getClass().getName());
	}
}
