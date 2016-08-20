/**
 * 
 */
package com.adobe.client.displays;


import com.adobe.client.DisplayElement;
import com.adobe.client.Observer;
import com.adobe.server.entity.DataPacket;

/**
 * @author danchara
 *
 */
public class CurrentConditionsDisplay implements DisplayElement, Observer {
	
	
	
	
	int temp ;
	int humidity;
	
	
	
	
	

	/* (non-Javadoc)
	 * @see com.adobe.client.Observer#update()
	 * 
	 * get updated values from WeatherData upon being notified
	 * called in WeatherData#notify
	 */
	@Override
	public void update(DataPacket dataPacket) {
		this.temp = dataPacket.getTemp();
		this.humidity = dataPacket.getHumidity();
		
	}

	/* (non-Javadoc)
	 * @see com.adobe.client.DisplayElement#display()
	 */
	@Override
	public void display() {
		System.out.println("Temparature :"+ temp+ "\n Humidity :"+humidity);
	}

}
