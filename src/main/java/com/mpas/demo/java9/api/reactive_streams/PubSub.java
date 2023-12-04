package com.mpas.demo.java9.api.reactive_streams;

import java.util.stream.Stream;

public class PubSub {

	/*
	 * Uses the new reactive stream interfaces to create a simple publisher/subscriber pipeline.
	 * Note that the JDK only defines a couple of basic interfaces (with the exception of
	 * SubmissionPublisher) for existing reactive stream libraries to integrate with.
	 */

	public static void main(String[] args) throws InterruptedException {
		IncrementingPublisher publisher = new IncrementingPublisher();
		Stream.of("A", "B", "C")
				.peek(name -> LoggingRandomDelaySubscriber.unsafeSleepRandomUpToMillis(20))
				.forEach(name -> LoggingRandomDelaySubscriber.createAndSubscribe(name, publisher));
		publisher.waitUntilTerminated();
	}

}
