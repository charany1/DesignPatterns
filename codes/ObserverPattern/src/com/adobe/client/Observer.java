package com.adobe.client;

import com.adobe.server.entity.DataPacket;

public interface Observer {
	void update(DataPacket dataPacket);

}
