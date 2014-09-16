package com.cashierbox;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class Transaction {
	
	BigDecimal donationAmt;
	BigDecimal taxAmt;
	BigDecimal totalAmt;
	int storeId;
	int cashBoxNo;
	int transactionNo;
	
	
	/**
	 * 
	 * @param store
	 * @param cashBoxNo
	 * @param taxRate
	 */
	public Transaction(int store, int cashBoxNo, BigDecimal taxRate) {
		BigDecimal baseAmt = new BigDecimal(ThreadLocalRandom.current().nextDouble());
		BigDecimal donationAmt = new BigDecimal(ThreadLocalRandom.current().nextDouble(5.0));
		this.taxAmt = baseAmt.multiply(taxRate);
		this.totalAmt = baseAmt.add(taxAmt).add(donationAmt);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("Store: ").append(storeId).append(" ");
		sb.append("CashierBox: ").append(cashBoxNo);
		return sb.toString();
	}
	
	/**
	 * 
	 */
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Store: " + storeId + " " );
		sb.append("Cashierbox: " + cashBoxNo + " ");
		sb.append("Total: " + totalAmt + " ");
		return sb.toString();
	}
}
