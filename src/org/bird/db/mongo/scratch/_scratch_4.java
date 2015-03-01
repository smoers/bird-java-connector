package org.bird.db.mongo.scratch;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;

import org.bird.system.config.BuilderXMLConfig;
import org.bird.system.config.XMLConfig;

public class _scratch_4 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		BuilderXMLConfig bxc = BuilderXMLConfig.getInstance();
		Hashtable tbl = new Hashtable();
		tbl.put(1,"Serge Moers");
		tbl.put(2,"Didier Moers");
		tbl.put(3,"Laurent Moers");
		
		XMLConfig<Hashtable> xml = bxc.<Hashtable>getXMLConfig(BuilderXMLConfig.DEFAULT_CONNECTORS_FILENAME);
		xml.writeConfig(tbl);
		
		System.out.println(xml.XMLConfigExist());
		
		Hashtable read = xml.readConfig();
		
		System.out.println(read.size());

	}

}
