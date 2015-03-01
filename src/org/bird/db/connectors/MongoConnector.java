package org.bird.db.connectors;

import java.util.UUID;

import org.bird.system.EnumBDBC;

public class MongoConnector extends Connector {

	private int port;
	private String server;
	
	public MongoConnector(EnumBDBC enumbdbc) {
		super(UUID.randomUUID(), enumbdbc);
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

}
