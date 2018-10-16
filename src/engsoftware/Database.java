package engsoftware;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("engenhariasoftware");
	protected static EntityManager manager = factory.createEntityManager();
	
	public void Inserir(Object o) throws IllegalArgumentException {
		try {
			manager.getTransaction().begin();
			manager.persist(o);
			manager.getTransaction().commit(); 
		}
		catch (IllegalArgumentException e) {
			throw e;
		}
		finally {
			manager.close();
		}
	}
}
