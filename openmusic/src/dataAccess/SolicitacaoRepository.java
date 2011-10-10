package dataAccess;

import domainModel.Solicitacao;

import java.util.List;

import javax.persistence.*;

public class SolicitacaoRepository {
	
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public SolicitacaoRepository(){
		factory = Persistence.createEntityManagerFactory("openmusic");
		manager = factory.createEntityManager();
	}
	
	public void Save(Solicitacao obj) throws Exception{
		try{
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(obj);
			transaction.commit();
		}
		catch(Exception ex){
			transaction.rollback();
			throw ex;
		}
	}
	
	//verificar utilidade para a rede social
	public void Delete(Solicitacao obj) throws Exception{
		try{
			transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(obj);
			transaction.commit();
		}
		catch(Exception ex){
			transaction.rollback();
			throw ex;
		}
	}
	
	
	public Solicitacao Open(int id) throws Exception{
		try{
			return manager.find(Solicitacao.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName(){
		return manager.createQuery("select u from Solicitacao u order by u.id")
		.setMaxResults(10).getResultList();
	}
	
	public Solicitacao getByUsuario(int cod1, int cod2){
		try{
			return (Solicitacao) manager.createQuery("select s from Solicitacao s join s.solicitado u join s.solicitador us where (u.id =:id1 and us.id =:id2) or (u.id =:id2 and us.id =:id1)")
			.setParameter("id1", cod1)
			.setParameter("id2", cod2)
			.getSingleResult();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public List getBySolicitacao(int cod){
		return manager.createQuery("select s from Solicitacao s join s.solicitado u where u.id =:id")
		.setParameter("id", cod)
		.getResultList();
	}

}
