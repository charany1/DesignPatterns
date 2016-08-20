/**
 * 
 */
package com.adobe.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.adobe.client.Observer;
import com.adobe.server.entity.DataPacket;

/**
 * @author danchara
 *
 */
public class WeatherData implements Subject{
	
	DataPacket dataPacket = new DataPacket(0,0);
	
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
			observer.update(dataPacket);
		}
	}
	
	
	
	/*
	 * This methods updates new temp and humidity each time it get new data from backend
	 * hardware device.
	 * */
	public void measurementsChanged(){
		dataPacket.setTemp(ThreadLocalRandom.current().nextInt(20, 30 + 1));
		dataPacket.setHumidity(ThreadLocalRandom.current().nextInt(50, 60 + 1));
		notifyObservers();
				
		
	}
	

}
