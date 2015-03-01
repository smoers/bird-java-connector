package org.bird.system;

import java.util.Hashtable;
import org.bird.db.interfaces.IBook;
import org.bird.system.interfaces.IListBook;

public class ListBook extends Hashtable<Object, IBook> implements IListBook {

	@Override
	public IListBook find(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
