package com.mpas.demo.java22;

import java.util.*;

public class Unnamed6 {
	public static <T> Iterable<T> toIterable(Iterator<T> iterator) {
		return () -> iterator;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner("Mary had a little lamb");
		int count = 0;
		while (in.hasNext()) {
			count++;
			var _ = in.next();
		}
		System.out.println(count);

		in = new Scanner("Mary had a little lamb");
		count = 0;
		for (var _ : toIterable(in)) count++;
		System.out.println(count);

		count = 0;
		for (Scanner words = new Scanner("Mary  had a little lamb"), _ = words.useDelimiter("\\s+");
				words.hasNext(); words.next()) {
			count++;
		}
		System.out.println(count);
	}
}
