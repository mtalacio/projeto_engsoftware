package engsoftware;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("engenhariasoftware");
		EntityManager manager = factory.createEntityManager();
		
		//Politico p1 = new Politico("Matheus", "Talacio", Cargos.GOVERNADOR, 110);
		//Politico p2 = new Politico("Talacio", "Talacio", Cargos.DEP_ESTADUAL, 110);
		
		//manager.getTransaction().begin();
		//manager.persist(p1);
		//manager.persist(p2);
		//manager.getTransaction().commit();
		
		//System.out.println("Id Matheus: " + p1.getId());
		//System.out.println("Id Talacio: " + p2.getId());
		
		manager.close();
		factory.close();

	}

}
