package com.borabora;

/**
 * Created by epauser on 13/08/14.
 */
public class SampleConsumer implements java.util.function.Consumer<Sample> {

    private static final long PAUSE = 500;

    @Override
    public void accept(Sample sample) {
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (sample != null) {
            System.out.println("\t\tConsuming sample " + sample);
        } else {
            System.out.println("No samples");
        }
    }
}
