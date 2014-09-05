package com.borabora;

import java.util.stream.Stream;

/**
 * Created by epauser on 12/08/14.
 */
public class Main {

	public static void main(String[] args) {

        //Create producers
		SampleSupplier supplier1 = new SampleSupplier("supplier1");
		SampleSupplier supplier2 = new SampleSupplier("supplier2");
		SampleSupplier supplier3 = new SampleSupplier("supplier3");

        //Create consumers
        SampleConsumer sampleConsumer1 = new SampleConsumer("sampleConsumer1");
        SampleConsumer sampleConsumer2 = new SampleConsumer("sampleConsumer2");
        SampleConsumer sampleConsumer3 = new SampleConsumer("sampleConsumer3");

        //Producers fill in the same stream
		Stream<Sample> sampleFlow = Stream.generate(supplier1)
				.flatMap(x -> Stream.of(x, supplier2.get()))
                .flatMap(x -> Stream.of(x, supplier3.get()));

        //Consumers deplete the same stream
        sampleFlow
                .peek(sampleConsumer1)
                .peek(sampleConsumer2)
				.forEach(sampleConsumer3);
	}
}
