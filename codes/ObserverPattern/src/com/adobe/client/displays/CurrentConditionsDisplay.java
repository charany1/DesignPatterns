/**
 * 
 */
package com.adobe.client.displays;


import com.adobe.client.DisplayElement;
import com.adobe.client.Observer;
import com.adobe.server.WeatherData;

/**
 * @author danchara
 *
 */
public class CurrentConditionsDisplay implements DisplayElement, Observer {
	
	
	WeatherData weatherData ;
	
	int temp ;
	int humidity;
	
	
	
	
	public CurrentConditionsDisplay(WeatherData weatherData) {
		super();
		this.weatherData = weatherData;
	}

	/* (non-Javadoc)
	 * @see com.adobe.client.Observer#update()
	 * 
	 * get updated values from WeatherData upon being notified
	 * called in WeatherData#notify
	 */
	@Override
	public void update() {
		temp = weatherData.getTemparature();
		humidity = weatherData.getHumidity();
		
	}

	/* (non-Javadoc)
	 * @see com.adobe.client.DisplayElement#display()
	 */
	@Override
	public void display() {
		System.out.println("Temparature :"+ temp+ "\n Humidity :"+humidity);
	}

}
