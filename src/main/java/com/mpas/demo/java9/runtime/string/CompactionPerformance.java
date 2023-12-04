package com.mpas.demo.java9.runtime.string;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class CompactionPerformance {

	public static void main(String[] args) throws InterruptedException {
		// time to connect profiler (at least JVisualVM doesn't want to :( )
//		Thread.sleep(5_000);

		long launchTime = System.currentTimeMillis();
		List<String> strings = IntStream.rangeClosed(1, 10_000_000)
				.mapToObj(Integer::toString)
				.collect(toList());
		long runTime = System.currentTimeMillis() - launchTime;
		System.out.println("Generated " + strings.size() + " strings in " + runTime + " ms.");

		launchTime = System.currentTimeMillis();
		String appended = strings.stream()
				.limit(100_000)
				.reduce("", (left, right) -> left + right);
		runTime = System.currentTimeMillis() - launchTime;
		System.out.println("Created string of length " + appended.length() + " in " + runTime + " ms.");
	}

}
