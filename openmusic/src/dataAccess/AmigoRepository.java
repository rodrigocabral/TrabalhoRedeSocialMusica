package dataAccess;

import domainModel.Amigo;

import java.util.List;

import javax.persistence.*;

public class AmigoRepository {
	
	private EntityManager maneger;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public AmigoRepository(){
		factory = Persistence.createEntityManagerFactory("openmusic");
		maneger = factory.createEntityManager();
	}
	
	public void Save(Amigo obj) throws Exception{
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
	public void Delete(Amigo obj) throws Exception{
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
	
	
	public Amigo Open(int id) throws Exception{
		try{
			return maneger.find(Amigo.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName(int cod){
		return maneger.createQuery("select a, u, us from Amigo a join a.idamigo1 u join a.idamigo2 us where u.id =:id or us.id =:id")
		.setParameter("id", cod)
		.setMaxResults(10).getResultList();
	}

}
