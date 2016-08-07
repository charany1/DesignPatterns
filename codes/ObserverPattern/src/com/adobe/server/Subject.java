/**
 * 
 */
package com.adobe.server;

import com.adobe.client.Observer;

/**
 * @author danchara
 *
 */
public interface Subject {
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();


}
