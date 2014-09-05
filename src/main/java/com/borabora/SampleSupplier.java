package com.borabora;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by epauser on 13/08/14.
 */
public class SampleSupplier implements java.util.function.Supplier<Sample> {

    private static final long PAUSE = 1000;
    Sample buffer = new Sample("");
    String id;

    public SampleSupplier(String id) {
    	this.id = id;
       new Thread() {
           @Override
           public void run() {
               int i = 0;
               while (true) {
                   buffer = new Sample("Sample " + (++i) + " from " + id);
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
        return buffer;
    }
}
