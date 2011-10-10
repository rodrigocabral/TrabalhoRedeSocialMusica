package dataAccess;

import domainModel.Mixagem;

import java.util.List;

import javax.persistence.*;

public class MixagemRepository {
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public MixagemRepository(){
		factory = Persistence.createEntityManagerFactory("openmusic");
		manager = factory.createEntityManager();
	}

	public void Save(Mixagem obj) throws Exception{
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
	
	public void Delete(Mixagem obj) throws Exception{
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
	
	
	public Mixagem Open(int id) throws Exception{
		try{
			return manager.find(Mixagem.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName(){
		return manager.createQuery("select m from Mixagem m order by m.id")
		.setMaxResults(10).getResultList();
	}
	
	public List getBySolicitacao(int cod_musica){
		return manager.createQuery("select m from Mixagem m join m.musica mu where mu.id =:id")
		.setParameter("id", cod_musica)
		.getResultList();
	}
	
}
