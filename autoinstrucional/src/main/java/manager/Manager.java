package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
	
	private static EntityManagerFactory emf;
	
	private static EntityManager em;
	
	public static EntityManager getEntityManager() {
		
		if(emf == null){
			emf= Persistence.createEntityManagerFactory("autoinstrucional");
		}
		if(em == null) {
			em = emf.createEntityManager();
		}
		
		return em;
	}

}
