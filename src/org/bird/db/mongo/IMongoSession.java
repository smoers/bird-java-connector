package org.bird.db.mongo;

import com.mongodb.MongoClient;

public interface IMongoSession {

	//Retourne une instance de la classe MongoClient
	public abstract MongoClient getMongoClient();

}