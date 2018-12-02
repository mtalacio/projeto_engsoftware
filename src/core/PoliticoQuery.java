package core;

import java.util.List;

import javax.persistence.Query;

public class PoliticoQuery extends Database {
	
	// TODO: Adicionar validações
	
	@SuppressWarnings("unchecked")
	public static List<Politico> PesquisarPorMatricula(long matricula) {
		Query qry = manager.createQuery("select a from Politico as a where a.inscricaoEleitoral = :param1");
		qry.setParameter("param1", matricula);
		
		return qry.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Politico> PesquisarPorSobrenome(String sobrenome) {
		Query qry = manager.createQuery("select a from Politico as a where a.sobrenome = :param1");
		qry.setParameter("param1", sobrenome);
		
		return qry.getResultList();
	}

	public static Politico PesquisarPorId(int id) {
		Query qry = manager.createQuery("select a from Politico as a where a.id = :param1");
		qry.setParameter("param1", id);
		
		return (Politico)qry.getSingleResult();
	}
	
	public static void Excluir(int id) {
		Politico p = manager.find(Politico.class, id);
		manager.getTransaction().begin();
		manager.remove(p);
		manager.getTransaction().commit();
	}
	
	public static void Atualizar(Politico p) {
		manager.getTransaction().begin();
		manager.merge(p);
		manager.getTransaction().commit();
	}
}
