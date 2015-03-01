package org.bird.db.mongo;

import java.util.Hashtable;

import org.bird.db.mongo.exceptions.MongoSessionException;

public class MongoBuilder {
	
	private static int sPort = 27017;
	private static String sServer = "localhost";
	private Hashtable<String,MongoSession> sMongoSession;
	
	/*
	 * Singleton donc instance unique
	 */
	private MongoBuilder(){
		sMongoSession = new Hashtable();
	}
	
	/*
	 * Methode pour obtenir une instance de la classe
	 * @return Instance MongoBuilder
	 * @see MongoBuilder
	 */
	public static MongoBuilder getInstance(){
		return new MongoBuilder();
	}
	
	/*
	 * Retourne une nouvelle instance d'un objet
	 * @param Key est la valeur permettant de retrouver une session precise dans le builder
	 * @return Instance MongoSession
	 */
	public IMongoSession getInstanceMongoSession(String key) throws MongoSessionException{
		sMongoSession.put(key, new MongoSession(MongoBuilder.getServer(), MongoBuilder.getPort()));
		return sMongoSession.get(key);
	}
	
	/*
	 * Obtenir le port par default
	 * @return Port par defaut : Type int
	 */
	public static int getPort(){
		return sPort;
	}
	
	/*
	 * Obtenir le serveur par default
	 * @return Serveur par defaut : Type String
	 */
	public static String getServer(){
		return sServer;
	}

}
