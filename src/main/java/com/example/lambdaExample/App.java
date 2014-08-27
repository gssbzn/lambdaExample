package com.example.lambdaExample;

import java.math.BigDecimal;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @author Gustavo Bazan
 *
 */
public class App 
{
	private static AtomicLong transaccion = new AtomicLong(0);
	private static ConcurrentLinkedQueue<Venta> ventas = new ConcurrentLinkedQueue<>(); 
    
	public static void main( String[] args ) throws InterruptedException{
		BigDecimal total;
    	   	
		Thread t = new Thread(new simularVentas());
		t.start();
    	do{
			total = ventas.stream().parallel().map((x) -> x.getMonto()).reduce((x,y) -> x.add(y)).get();
	    	System.out.print("\rtotal="+total);
	    	Thread.sleep(2500);
    	}while(true);
    	
    	//t.interrupt();
    	
    }
	
	private static class simularVentas implements Runnable {
		@Override
        public void run() {
			do{
				try{
					Thread t = new Thread(new vender());
					t.start();
					Thread.sleep(1000);
					t.join();
				}catch(InterruptedException ex){
					return;
				}
			}while(true);
		}
	}
	
    private static class vender implements Runnable {
    	
    	@Override
        public void run() {
    		Random a = new Random();
    		OptionalDouble amt = a.doubles(1, 500).findAny();
    		BigDecimal ventaAmt;
    		if(amt.isPresent())
    			ventaAmt = new BigDecimal(amt.getAsDouble());
    		else
    			ventaAmt = BigDecimal.ZERO;
        	Venta venta = new Venta(transaccion.getAndIncrement(), ventaAmt.setScale(2, BigDecimal.ROUND_HALF_UP));
        	ventas.add(venta);
        }
    }
}
