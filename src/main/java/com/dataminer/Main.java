/**
 * 
 */
package com.dataminer;


/**
 * @author EPA000\eve0016691
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataMiner data = new DataMiner("properties/dataminer.properties");
		try {
			data.initData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
