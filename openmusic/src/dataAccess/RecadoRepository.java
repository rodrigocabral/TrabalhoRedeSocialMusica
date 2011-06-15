package dataAccess;

import domainModel.Recado;

import java.util.List;

import javax.persistence.*;

public class RecadoRepository {
	
	private EntityManager maneger;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public RecadoRepository(){
		factory = Persistence.createEntityManagerFactory("openmusic");
		maneger = factory.createEntityManager();
	}
	
	public void Save(Recado obj) throws Exception{
		try{
			transaction = maneger.getTransaction();
			transaction.begin();
			maneger.persist(obj);
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
			transaction = maneger.getTransaction();
			transaction.begin();
			maneger.remove(obj);
			transaction.commit();
		}
		catch(Exception ex){
			transaction.rollback();
			throw ex;
		}
	}
	
	
	public Recado Open(int id) throws Exception{
		try{
			return maneger.find(Recado.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName(){
		return maneger.createQuery("select u from Recado u order by u.id")
		.setMaxResults(10).getResultList();
	}

}
