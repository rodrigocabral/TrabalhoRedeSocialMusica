package dataAccess;

import domainModel.Recado;

import java.util.List;

import javax.persistence.*;

public class RecadoRepository {
	
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public RecadoRepository(){
		factory = Persistence.createEntityManagerFactory("openmusic");
		manager = factory.createEntityManager();
	}
	
	public void Save(Recado obj) throws Exception{
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
	public void Delete(Recado obj) throws Exception{
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
	
	
	public Recado Open(int id) throws Exception{
		try{
			return manager.find(Recado.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName(int cod){
		return manager.createQuery("select r from Recado r join r.usuario u where u.id  =:id order by r.id desc")
		.setParameter("id", cod)
		.setMaxResults(10).getResultList();
	}

}
