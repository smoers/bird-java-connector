package org.bird.db.mongo.scratch;

import org.bird.db.interfaces.IAuthor;

public class _scratch_2 {

	public static void main(String[] args) {
		
		
		
		try {
			IAuthor author = (IAuthor) Class.forName("org.bird.system.Author").newInstance();
			author.setLastName("Moers");
			System.out.println(author.getLastName());
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
