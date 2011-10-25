package dataAccess;

import domainModel.Voto;

import java.util.List;

import javax.persistence.*;

public class VotoRepository {
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public VotoRepository(){
		factory = Persistence.createEntityManagerFactory("openmusic");
		manager = factory.createEntityManager();
	}

	public void Save(Voto obj) throws Exception{
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
	
	public void Delete(Voto obj) throws Exception{
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
	
	
	public Voto Open(int id) throws Exception{
		try{
			return manager.find(Voto.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName(){
		return manager.createQuery("select v from Voto v order by v.id")
		.setMaxResults(10).getResultList();
	}
	
	public List getByUsuario(int cod){
		return manager.createQuery("select v from Voto v join v.usuario u where u.id =:id")
		.setParameter("id", cod)
		.getResultList();
	}
	
	public List getByMusica(int cod){
		return manager.createQuery("select v from Voto v join v.musica m where m.id =:id")
		.setParameter("id", cod)
		.getResultList();
	}
}
