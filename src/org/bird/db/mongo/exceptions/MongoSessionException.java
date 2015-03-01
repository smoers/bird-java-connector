package org.bird.db.mongo.exceptions;

/*
 * Cette Class personnalise les exceptions levees par le package Mongo
 */
public class MongoSessionException extends Exception {
	
	
	public MongoSessionException(String s){
		super(s);
	}
	/*
	 * Contructeur 
	 * @param e : Type java.lang.Exception
	 */
	public MongoSessionException(Exception e){
		super(e.getMessage());
	}
	
}
