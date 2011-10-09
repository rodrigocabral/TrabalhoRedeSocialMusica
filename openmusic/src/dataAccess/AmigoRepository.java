package dataAccess;

import domainModel.Amigo;
import domainModel.Usuario;

import java.util.List;

import javax.persistence.*;

public class AmigoRepository {
	
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public AmigoRepository(){
		factory = Persistence.createEntityManagerFactory("openmusic");
		manager = factory.createEntityManager();
	}
	
	public void Save(Amigo obj) throws Exception{
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
	public void Delete(Amigo obj) throws Exception{
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
	
	
	public Amigo Open(int id) throws Exception{
		try{
			return manager.find(Amigo.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName(int cod){
		try{
		return manager.createQuery("select a from Amigo a join a.amigo1 u join a.amigo2 us where u.id =:id or us.id =:id2")
		.setParameter("id", cod)
		.setParameter("id2", cod)
		.setMaxResults(10).getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public Amigo getByName(int cod1, int cod2) {
		try{
		return (Amigo) manager.createQuery("select a from Amigo a join a.amigo1 u join a.amigo2 us where (u.id =:id and us.id =:id2) or (u.id =:id2 and us.id =:id)")
		.setParameter("id", cod1)
		.setParameter("id2", cod2)
		.getSingleResult();	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
