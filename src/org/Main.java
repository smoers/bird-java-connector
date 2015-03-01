package org;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bird.db.mongo.IMongoSession;
import org.bird.db.mongo.MongoBuilder;

import com.mongodb.DB;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MongoBuilder mb;
		IMongoSession ms;
		try {
			mb = MongoBuilder.getInstance();
			ms = mb.getInstanceMongoSession("test");
			List list = ms.getMongoClient().getDatabaseNames();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				String name = (String) it.next();
				System.out.println(name);
				
			}
			
			DB db = ms.getMongoClient().getDB("bird");
			Set set=db.getCollectionNames();
			System.out.println(set.contains("oo"));
			System.out.println(ms.getMongoClient().getUsedDatabases().toString());
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
