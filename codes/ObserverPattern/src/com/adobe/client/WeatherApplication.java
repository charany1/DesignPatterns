/**
 * 
 */
package com.adobe.client;

import com.adobe.client.displays.CurrentConditionsDisplay;
import com.adobe.client.displays.StatsDisplay;
import com.adobe.server.WeatherData;

/**
 * @author danchara
 *
 */
public class WeatherApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		
		System.out.println("Creating a Subject:only 1 instance to be created,here WeatherData");
		WeatherData weatherData = new WeatherData();
		
		System.out.println("Creatinng new observer , here CurrentConditionsDisplay");
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
		
		System.out.println("Creating a new observer , here StatsDisplay");
		StatsDisplay statsDisplay = new StatsDisplay();
		
	
		
		System.out.println("SIMULATION STARTS :WeatherData starts notifying observers and updates them.");
		
		
		
		
		for (int i = 0; i <= 20; i++) {
			
			
			//measurement changes each time in hardware device which in turn gets updated in Server side.
			weatherData.measurementsChanged();
			
			//Following lines contain simulation for runtime registration and removal of objects .
			
			if(i==5){
				weatherData.registerObserver(currentConditionsDisplay);
			}
			
			if(i==9){
				weatherData.registerObserver(statsDisplay);
			}
			
			if(i==15){
				weatherData.removeObserver(currentConditionsDisplay);
			}
			if(i==18){
				weatherData.registerObserver(currentConditionsDisplay);
				weatherData.removeObserver(statsDisplay);
			}
			
			if(i==20){
				weatherData.removeObserver(currentConditionsDisplay);
			}
			
			
			
			System.out.println("========Application____Displays=======");
			
			for(Observer observer : WeatherData.observerList){
				
				if(WeatherData.observerList.isEmpty()){
					System.out.println("Empty List");
				}else{
				
				//type-casting to DisplayElement to use DisplayElement#display
				DisplayElement currentDisplay = (DisplayElement)observer;
				
				currentDisplay.display();
				}
			}
			
		}
	}

}
