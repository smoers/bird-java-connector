package org.bird.sandbox.connector;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import org.bird.db.connectors.BuilderConnector;
import org.bird.db.connectors.IConnector;
import org.bird.db.exceptions.DbException;
import org.bird.system.EnumBDBC;
import org.bird.system.config.exceptions.XMLConfigException;


public class _SandBox_01 {

	public static void main(String[] args) throws XMLConfigException, DbException {
		
		BuilderConnector bc = BuilderConnector.getInstance();
		
		bc.ReadFileConfigConnectors();
		
		IConnector con = bc.getConnector(UUID.fromString("bd0a1906-ccf9-4b01-9d72-1f39d35b2708"));
		con.setName("Test Reussi 2");
		bc.AddConnectorAtList(con);
		
		Hashtable ht = bc.getListConnector();
		Set<Entry<UUID,IConnector>> set = ht.entrySet();
		Iterator<Entry<UUID, IConnector>> it = set.iterator();
		
		while(it.hasNext()){
			Entry<UUID, IConnector> entry = it.next();
			System.out.println(entry.getValue().getID() + " " + entry.getValue().getName());			
		}
		
		IConnector connector = bc.getNewConnector(EnumBDBC.MongoDB);
		
		connector.setName("Mongo Test 3");
		
		//bc.AddConnectorAtList(connector);
		bc.WriteFileConfigConnectors();
		
		System.out.println(connector.getID());
		

	}

}
