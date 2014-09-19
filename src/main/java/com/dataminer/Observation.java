/**
 * 
 */
package com.dataminer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author EPA000\eve0016691
 *
 */
public class Observation {
	
	/** */
	private final static int ARRIVAL_TIME = 0;
	/** */
	private final static int BASE_AMT = 1;
	/** */
	private final static int TAX_AMT = 2;
	/** */
	private final static int TOTAL_AMT = 3;
	/** */
	private final static int DEVOLUTION_AMT = 4;
	/** */
	private final static int DONATION_AMT = 5;
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
		this.processed = false;
	}
	
	/**
	 * <p> 
	 * This method obtain the data from the observation. <br>
	 * The data has the following format: <br> 
	 * [Arrival time] [Base Amt] [Tax Amt] [Total Amt] [Devolution Amt] [Donation Amt]  
	 * @return {@code List<String[]>}
	 * @throws Exception
	 */
	private List<String[]> readData() throws Exception{
		File file = new File(getClass().
				getClassLoader().getResource("observations/" + this.id + ".csv").toURI());
		FileReader filereader = new FileReader(file);
		CSVReader reader = new CSVReader(filereader);
		List<String[]> list = reader.readAll();
		reader.close();
		return list;
	}
	
	/**
	 * <p>
	 * this method process the observation data 
	 * and generate statistics over the data 
	 * @return {@code boolean}
	 */
	public boolean processData() throws Exception {
		if(!processed){
			try {
				List<String[]> arrivalsData = readData();
				BigDecimal arrivalsTimeAcum = BigDecimal.ZERO;
				BigDecimal arrivalTime;
				HashMap<String, BigDecimal> arrivalsTime = new HashMap<String, BigDecimal>();
				LocalTime newArrivalTime = null;
				LocalTime oldArrivalTime = null;
				Time actualArrivalTime = new Time(System.currentTimeMillis());
				Time pastArrivalTime = new Time(System.currentTimeMillis());
				int arrivalCont = 1;
				for (String[] arrival : arrivalsData) {
					
					arrivalTime = getArrivalTime(actualArrivalTime, pastArrivalTime, 
							arrivalCont, arrival[ARRIVAL_TIME]);
					
					arrivalsTime.put(String.valueOf(arrivalsNo), arrivalTime);
					arrivalsTimeAcum = arrivalsTimeAcum.add(arrivalTime);
					arrivalsNo++;
				}
				processed = true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
			}
		}
		return processed;
	}
	
	/**
	 * <p>
	 * 
	 * @param arrivalTime
	 * @return
	 * @throws Exception 
	 */
	private BigDecimal getArrivalTime(LocalTime actualTime, LocalTime pastTime, 
			int arrivalNo, String arrivalTime) throws Exception{
		
		actualTime.parse(arrivalTime);
		if(arrivalNo == 1)
			pastTime = actualTime;
		
		return new BigDecimal((actualTime.getTime() - pastTime.getTime()) );
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.id + " [arrivalsNo=");
		buffer.append(this.arrivalsNo);
		buffer.append(", arrivalMedia=");
		buffer.append(this.arrivalMedia);
		buffer.append(", arrivalMax=");
		buffer.append(this.arrivalMax);
		buffer.append(", arrivalModa=");
		buffer.append(this.arrivalModa);
		buffer.append(", totalAmt=");
		buffer.append(this.totalAmt);
		buffer.append(", TaxAmt=");
		buffer.append(this.TaxAmt);
		buffer.append(", donationAmt=");
		buffer.append(this.donationAmt);
		buffer.append(", devolutionAmt=");
		buffer.append(this.devolutionAmt);
		buffer.append(", processed=");
		buffer.append(this.processed);
		buffer.append("]");
		return buffer.toString();
	}
	
	
}
