package com.borabora;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by epauser on 13/08/14.
 */
public class SampleSupplier<T> implements java.util.function.Supplier<Sample> {

    private static final int CAPACITY = 200;
    private static final long PAUSE = 1000;
    //ArrayBlockingQueue<Sample> buffer = new ArrayBlockingQueue<>(CAPACITY);
    Sample buffer = new Sample("");
    String id;

    public SampleSupplier(String id) {
    	this.id = id;
       new Thread() {
           @Override
           public void run() {
               int i = 0;
               while (true) {
                   Sample sample = new Sample(++i+id);
                   //buffer.add(sample);
                   buffer = sample;
                   //System.out.println("New sample " + sample + " arrived. " + buffer.size());
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
        //return buffer.poll();
    	Sample aux = buffer;
    	buffer = null;
    	return aux;
    }
}
