/**
 * 
 */
package com.dataminer;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author EPA000\eve0016691
 *
 */
public class DataMiner {
	
	/** */
	private String file;
	/** */
	private String prefix;
	/** */
	private String[] filenames;
	/** */ 
	private boolean initialized = false;
	/** */
	private Observation[] observations;
	/** */
	private Properties properties;
	
	/**
	 * 
	 * @param propertyFile
	 */
	public DataMiner(String propertyFile) {
		properties = new Properties();
        file = propertyFile;
        initialized = false;
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void initData() throws Exception{
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
		int qty;
        properties.load(inputStream);
        
        this.prefix = properties.getProperty("Prefix");
        qty = Integer.valueOf(properties.getProperty("ObservationsNo"));
        this.filenames = new String[qty];
        this.observations = new Observation[qty];
        for(int i = 0; i < qty; i++){
        	this.filenames[i] = prefix + (i + 1);
        }
	}

	/**
	 * 
	 * @param pos
	 * @return
	 * @throws Exception 
	 */
	public Observation getProcessedData(int observationNo) throws Exception{
		if(observationNo <= 0)
			throw new IllegalArgumentException("value not valid, value must be greater than zero");
		else if(observationNo > this.observations.length)
			throw new IllegalArgumentException("value not valid, value must ");
		
		if(!this.initialized)
			initData();
		
		if(!observations[observationNo].isProcessed())
			observations[observationNo].process();
		
		return observations[observationNo];
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean processAll(){
		/* TODO procesar todas las observaciones y crear el archivo de 
		 * propiedades del simulador de la caja registradora
		 * */
		return false;
	}
	
	/**
	 * 
	 * @param observation
	 * @return
	 */
	public boolean isProcessed(int observationNo) {
		if(observationNo <= 0)
			throw new IllegalArgumentException("value not valid, value must be greater than zero");
		return this.observations[observationNo].isProcessed();
	}

	/**
	 * 
	 * @return
	 */
	public boolean isProcessed(){
		boolean status = true;
		int cont = 0;
		while(status || cont < observations.length){
			status &= observations[cont].isProcessed();
		}
		return status;
	}
	
}
