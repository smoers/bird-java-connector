package org.bird.system;

import org.bird.db.interfaces.IWhoIam;

/*
 * Cette classe va contenir les info sur une collection/database
 * L'id de la database ne peut être modifié, il est unique et doit être
 * généré par la méthode static de la classe CRUD
 */
public final class WhoIam implements IWhoIam {
	
	private String databasename;
	private String databasedescription;
	private final String databaseid; //Pour assurer que l'Id de la database ne sera pas modifier l'objet une fois créé
	
	/*
	 * constructeur
	 * @param databaseid type String 
	 */
	public WhoIam(String databaseid){
		this.databaseid = databaseid;
	}

	
	@Override
	public String getDatabaseName() {
		return this.databasename;
	}

	@Override
	public void setDatabaseName(String databasename) {
		this.databasename = databasename;
	}

	@Override
	public String getDatabaseDesciption() {
		return this.databasedescription;
	}

	@Override
	public void setDatabaseDescription(String databasedescription) {
		this.databasedescription = databasedescription;

	}

	@Override
	public String getDatabaseId() {
		return this.databaseid;
	}

}
