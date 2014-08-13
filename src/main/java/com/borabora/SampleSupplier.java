package com.borabora;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by epauser on 13/08/14.
 */
public class SampleSupplier<T> implements java.util.function.Supplier<Sample> {

    private static final int CAPACITY = 32000;
    private static final long PAUSE = 61;
    ArrayBlockingQueue<Sample> buffer = new ArrayBlockingQueue<>(CAPACITY);

    public SampleSupplier() {
       new Thread() {
           @Override
           public void run() {
               int i = 0;
               while (true) {
                   Sample sample = new Sample(++i);
                   buffer.add(sample);
                   System.out.println("New sample " + sample + " arrived. " + buffer.size());
                   try {
                       Thread.sleep(PAUSE);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       }.start();
    }

    @Override
    public Sample get() {
        return buffer.poll();
    }
}
