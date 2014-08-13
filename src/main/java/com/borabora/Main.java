package com.borabora;

import java.util.stream.Stream;

/**
 * Created by epauser on 12/08/14.
 */
public class Main {

    public static void main(String[] args) {

        Stream<Sample> sampleFlow = Stream.generate(new SampleSupplier());
        sampleFlow.forEach(new SampleConsumer());
    }
}
