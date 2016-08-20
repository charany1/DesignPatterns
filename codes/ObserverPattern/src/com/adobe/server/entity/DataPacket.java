/**
 * 
 */
package com.adobe.server.entity;

/**
 * @author danchara
 * 
 * Entity class for Data Packet sent by Subject to Observers .
 *
 */
public class DataPacket {
	int temp;
	int humidity;
	public DataPacket(int temp, int humidity) {
		super();
		this.temp = temp;
		this.humidity = humidity;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	};
	
	

}
