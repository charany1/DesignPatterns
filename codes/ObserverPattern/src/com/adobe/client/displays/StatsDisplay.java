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
 * Class used to display stats : max temp , min temp , max humidity , min humidity in app.
 *
 */
public class StatsDisplay implements DisplayElement , Observer{
	
	int maxTemp , maxHumidity ;
	
	
	
	@Override
	public void update(DataPacket dataPacket) {
		this.maxTemp = Integer.max(maxTemp, dataPacket.getTemp());
		this.maxHumidity = Integer.max(maxHumidity, dataPacket.getHumidity());
		
	}

	@Override
	public void display() {
		System.out.println("Max Temp : "+ maxTemp);
		System.out.println("Max Humidity : "+ maxHumidity);
		
	}

}
