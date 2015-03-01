package org.bird.db.mongo;

import org.bird.db.interfaces.ICrud;
import org.bird.db.interfaces.IWhoIam;
import org.bird.db.mongo.exceptions.MongoSessionException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;

public class CrudMongo implements ICrud {
	
	private IMongoSession mongosession = null;
	private IWhoIam whoiam = null;
	
	/** Constructeur privé */
	private CrudMongo(){}
	
	/** Holder */
	private static class SingletonHolder{	
		/** Instance unique non préinitialisée */
		private final static CrudMongo instance = new CrudMongo();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static CrudMongo getInstance(){
		return SingletonHolder.instance;
	}

	/**
	 * Retourne la MongoSession par défaut
	 * @return MongoSession
	 */
	public IMongoSession getDefaultMongosession() {
		return mongosession;
	}

	/**
	 * Défini la MongoSession utilisée par défaut
	 * @param mongosession
	 */
	public void setDefaultMongosession(IMongoSession mongosession) {
		this.mongosession = mongosession;
	}
	
	/**
	 * Permet de tester si la MongoSession par défaut est définie
	 * @throws MongoSessionException
	 */
	private void testDefaultMongoSession() throws MongoSessionException{
		if(this.mongosession==null){
			throw new MongoSessionException("Mongo-3");
		}
	}
	
	/**
	 * Créée une nouvelle collection adans la database bird avec la session par défaut
	 * @param whoiam
	 * @return
	 * @throws MongoSessionException
	 */
	public MongoCollection createDatabase(IWhoIam whoiam) throws MongoSessionException{
		this.testDefaultMongoSession();
		return this.createDatabase(this.mongosession, whoiam);
	}
	
	/**
	 * Créée une nouvelle collection dans la database bird
	 * @param mongosession session a utiliser pour la création de la collection
	 * @param whoiam Object avec les informations sur la nouvelle collection
	 * @return MongoCollection nouvelle collection
	 */
	public MongoCollection createDatabase(IMongoSession mongosession, IWhoIam whoiam){
		
		DB db = mongosession.getMongoClient().getDB("bird"); //Récupère la database Bird
		Jongo jongo = new Jongo(db); //Instance Jongo
		MongoCollection whoiamcollection = jongo.getCollection("whoiam"); //Récupère la collection WhoIam
		whoiamcollection.insert(whoiam); //Sauvegarde l'object WhoIam
		return jongo.getCollection(whoiam.getDatabaseId());
		
	}
	
}
