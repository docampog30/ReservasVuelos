package co.com.reservas.domain.repositories.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseServiceLocator {
	
	private static EntityManagerFactory emf;
	
	static{
		try{
			emf = Persistence.createEntityManagerFactory("ReservasUnit");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static EntityManager getEntityManager(){
		
		return  emf.createEntityManager();
	}
}
