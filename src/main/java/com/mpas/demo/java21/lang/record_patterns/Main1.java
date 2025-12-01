package com.mpas.demo.java21.lang.record_patterns;

import java.util.*;

sealed interface SubSequence extends CharSequence permits Initial, Final, Middle {
	CharSequence seq();

	default int start() { return 0; }
	default int end() { return seq().length(); }

	default char charAt(int index) {
		Objects.checkIndex(index, length());
		return seq().charAt(start() + index);
	}

	default int length() {
		return switch (this) {
			case Initial(var __, var end) -> end;
			case Final(var seq, var start) -> seq.length() - start();
			case Middle(var ___, var start, var end) -> end - start;
		};
	}

	default CharSequence subSequence(int s, int e) {
		return switch (this) {
			case Initial(var seq, var end) when s == 0 -> new Initial(seq, e);
			case Final(var seq, var start) when start + e == seq.length() -> new Final(seq, start + s);
			default -> new Middle(seq(), start() + s, start() + e);
		};
	}
}

record Initial(CharSequence seq, int end) implements SubSequence {
	public Initial { Objects.checkIndex(end, seq.length()); }
	public String toString() { return seq.subSequence(0, end).toString(); }
}

record Final(CharSequence seq, int start) implements SubSequence {
	public Final { Objects.checkIndex(start, seq.length()); }
	public String toString() { return seq.subSequence(start, seq.length()).toString(); }
}

record Middle(CharSequence seq, int start, int end) implements SubSequence {
	public Middle { Objects.checkFromToIndex(start, end, seq.length()); }
	public String toString() { return seq.subSequence(start, end).toString(); }
}

public class Main1 {
	public static void main(String[] args) {
		CharSequence seq = new Final("Mississippi", 6);
		System.out.println(seq.length());
		System.out.println(seq.subSequence(0, 3));
		System.out.println(seq.subSequence(0, 3).getClass().getName());
	}
}
