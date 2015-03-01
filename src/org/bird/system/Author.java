package org.bird.system;

import org.bird.db.interfaces.IAuthor;
import org.bird.db.interfaces.IPhotoOrCover;
import org.bird.system.interfaces.IListCycle;
import org.joda.time.DateTime;

public class Author implements IAuthor {
	
	private String id;
	private String lastname;
	private String firstname;
	private String authoralias;
	private IPhotoOrCover photo;
	private String website;
	private String biography;
	private String comment;
	private DateTime borndate;
	private DateTime creationdate;
	private IListCycle listcycle;
	
	public Author(){}
	
	public Author(String lastname, String firstname){
		this.setLastName(lastname);
		this.setFirstName(firstname);
	}
	
	
	@Override
	public void setLastName(String lastname) {
		this.lastname = lastname;		
	}

	@Override
	public String getLastName() {
		return this.lastname;
	}

	@Override
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String getFirstName() {
		return this.firstname;
	}

	@Override
	public void setAuthorAlias(String authoralias) {
		this.authoralias = authoralias;
	}

	@Override
	public String getAuthorAlias() {
		return this.authoralias;
	}

	@Override
	public void setPhoto(IPhotoOrCover photo) {
		this.photo = photo;

	}

	@Override
	public IPhotoOrCover getPhoto() {
		return this.photo;
	}

	@Override
	public void setWebSite(String website) {
		this.website = website;

	}

	@Override
	public String getWebSite() {
		return this.website;
	}

	@Override
	public void setBiography(String biography) {
		this.biography = biography;
	}

	@Override
	public String getBiography() {
		return this.biography;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String getComment() {
		return this.comment;
	}

	@Override
	public void setBornDate(DateTime borndate) {
		this.borndate = borndate;
	}

	@Override
	public DateTime getBornDate() {
		return this.borndate;
	}

	@Override
	public void setCreationDate(DateTime creationdate) {
		this.creationdate = creationdate;
	}

	@Override
	public DateTime getCreationDate() {
		return this.creationdate;
	}

	@Override
	public void setListCycle(IListCycle listcycle) {
		this.listcycle = listcycle;
	}

	@Override
	public IListCycle getListCycle() {
		return this.listcycle;
	}


	@Override
	public String getID() {
		return id;
	}

}
