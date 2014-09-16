/**
 * 
 */
package com.dataminer;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author EPA000\eve0016691
 *
 */
public class Observation {

	/** */
	private int arrivalsNo;
	/** */
	private BigDecimal arrivalMedia; 
	/** */
	private BigDecimal arrivalMax;
	/** */
	private BigDecimal arrivalModa;
	/** */
	private BigDecimal totalAmt;
	/** */
	private BigDecimal TaxAmt;
	/** */
	private BigDecimal donationAmt;
	/** */
	private BigDecimal devolutionAmt;
	/** */
	private String id;
	/** */
	private boolean processed;
	  
	
	/**
	 * 
	 * @param filename
	 */
	public Observation(String filename) {
		this.id = filename;
		this.processed = false;
		this.arrivalsNo = 1;
		this.arrivalMax = BigDecimal.ZERO;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean process() {
		if(!processed){
			BigDecimal arrivalsAcum = BigDecimal.ZERO;
			HashMap<String, Integer> arrivals = new HashMap<String, Integer>();
			processed = true;
		}
		return processed;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isProcessed(){
		return this.processed;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * @return the arrivalsNo
	 */
	public int getArrivalsNo() {
		return this.arrivalsNo;
	}

	/**
	 * @return the arrivalMedia
	 */
	public BigDecimal getArrivalMedia() {
		return this.arrivalMedia;
	}
	
	public BigDecimal getArrivalModa(){
		return this.arrivalModa;
	}

	/**
	 * @return the arrivalMax
	 */
	public BigDecimal getArrivalMax() {
		return this.arrivalMax;
	}

	/**
	 * @return the totalAmt
	 */
	public BigDecimal getTotalAmt() {
		return this.totalAmt;
	}

	/**
	 * @return the taxAmt
	 */
	public BigDecimal getTaxAmt() {
		return this.TaxAmt;
	}

	/**
	 * @return the donationAmt
	 */
	public BigDecimal getDonationAmt() {
		return this.donationAmt;
	}

	/**
	 * @return the devolutionAmt
	 */
	public BigDecimal getDevolutionAmt() {
		return devolutionAmt;
	}
}
