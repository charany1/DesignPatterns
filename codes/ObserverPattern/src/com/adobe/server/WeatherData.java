/**
 * 
 */
package com.adobe.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.adobe.client.Observer;

/**
 * @author danchara
 *
 */
public class WeatherData implements Subject{
	
	int temp , humidity;
	
	public static List<Observer> observerList = new ArrayList<Observer>();

	@Override
	public void registerObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer :observerList){
			observer.update();
		}
	}
	
	public int getTemparature(){
		return  temp;
	}
	
	public int getHumidity(){
		return humidity;
	}
	
	/*
	 * This methods updates new temp and humidity each time it get new data from backend
	 * hardware device.
	 * */
	public void measurementsChanged(){
		temp = ThreadLocalRandom.current().nextInt(20, 30 + 1);
		humidity = ThreadLocalRandom.current().nextInt(50, 60 + 1);
		notifyObservers();
				
		
	}
	

}
