package core;

import java.util.List;

import javax.persistence.Query;

public class Autenticador extends Database {
	@SuppressWarnings("unchecked")
	public static boolean Autenticar(Admin a) {
		Query qry = manager.createQuery("select a from Admin as a where a.login = :param1");
		qry.setParameter("param1", a.getLogin());
		
		List<Admin> result = qry.getResultList();

		if (result.size() > 0) {
			return a.getSenha().equals(result.get(0).getSenha());
		} else {
			return false;
		}
	}
}
