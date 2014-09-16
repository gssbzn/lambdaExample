/**
 * 
 */
package com.cashierbox;

import java.math.BigDecimal;



/**
 * @author EPA000\eve0016691
 *
 */
public class TransactionSupplier implements java.util.function.Supplier<Transaction> {

	// TODO substituir por método estadistico 
	private static final long PAUSE = 1000;
	Transaction buffer;

	public TransactionSupplier(int store, int cashBoxNo, BigDecimal taxRate) {
		StringBuffer sb = new StringBuffer(0).append(store).append(0).append(cashBoxNo);
		new Thread(sb.toString()){
			@Override
            public void run() {
                int i = 0;
                while (true) {
                    buffer = new Transaction(store, cashBoxNo, taxRate);
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
	public Transaction get() {
		
		return null;
	}
	
}
