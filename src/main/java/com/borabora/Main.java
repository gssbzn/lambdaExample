package com.borabora;

import java.util.stream.Stream;

/**
 * Created by epauser on 12/08/14.
 */
public class Main {

	public static void main(String[] args) {

		SampleSupplier supllier2 = new SampleSupplier("22");
		Stream<Sample> sampleFlow = Stream.generate(new SampleSupplier("otro"))
				.flatMap(x -> Stream.of(x, supllier2.get()));
		long a = sampleFlow.peek(new SampleConsumer())
				.peek(new SampleConsumer()).count();
		System.out.println("estooo" + a);
	}
}
