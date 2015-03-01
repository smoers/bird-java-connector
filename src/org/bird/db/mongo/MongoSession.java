package org.bird.db.mongo;

import java.util.List;
import java.util.Iterator;

import org.bird.db.mongo.exceptions.MongoSessionException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoSession implements IMongoSession {

	private String sServer;
	private int sPort;
	private MongoClient sMongoClient = null;
	
	/*
	 * Constructeur
	 * @param server
	 * 				adresse du serveur Mongo
	 * @param port
	 * 				port du serveur Mongo
	 * @throws org.db.mongo.exception.MongoSessionException
	 */
	public MongoSession(String server, int port) throws MongoSessionException {
		
			sServer = server;
			sPort = port;
			try {
				sMongoClient = new MongoClient(sServer,sPort);
			} catch (Exception e) {
				throw new MongoSessionException(e);
			}
		
	}
	
	/*
	 * Retourne une instance de la classe MongoClient
	 * (non-Javadoc)
	 * @see org.db.mongo.IMongoSession#getMongoClient()
	 */
	@Override
	public MongoClient getMongoClient(){
		return sMongoClient;
	}
	
	/*
	 * Retourne la liste des collection disponible
	 * dans la database bird accessible depuis cette session
	 * 
	 */
	public List getDatabasesList() throws MongoSessionException{
		
		//Controle si la database bird existe
		if(!this.sMongoClient.getDatabaseNames().contains("bird")){
			throw new MongoSessionException("Mongo-1");
		}
				
		DB db = this.sMongoClient.getDB("bird"); //Récupére la database bird
		Jongo jongo = new Jongo(db); //Instance Jongo
		MongoCollection collection = jongo.getCollection("WhoIam"); 
		
		if(collection.count()==0){
			//La collection WhoIam n'existe pas donc impossible d'utiliser cette Database
			throw new MongoSessionException("Mongo-2");
		}
		
		List listdb;
		return listdb;
	}
	
	
		
}
