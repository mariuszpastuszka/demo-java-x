package com.mpas.demo.java22;

import java.util.*;
import java.util.stream.*;

public class Unnamed5 {
	public static void main(String[] args) {
		var index = new TreeMap<String, TreeSet<Integer>>();
		var word = "Mary";
		int pageNumber = 42;
		index.computeIfAbsent(word, _ -> new TreeSet<>()).add(pageNumber);
		System.out.println(index);
		var partitioned = Stream.of("Mary had a little lamb".split(" ")).collect(Collectors.partitioningBy(_ -> Math.random() < 0.5));
		System.out.println(partitioned);
	}
}
