package org.bird.db.mongo;

import org.bird.system.Author;
import org.bson.types.ObjectId;

public class AuthorMongo extends Author {
	
	private ObjectId _id;
	
	public void set_id(ObjectId _id){
		this._id = _id;
	}
	
	public Object get_id(){
		return this._id;
	}
	
	public String getID(){
		
		return this._id.toString();
	}

}
