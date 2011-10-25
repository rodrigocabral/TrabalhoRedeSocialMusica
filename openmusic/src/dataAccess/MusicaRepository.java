package dataAccess;

import domainModel.Musica;

import java.util.List;

import javax.persistence.*;

public class MusicaRepository {
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public MusicaRepository(){
		factory = Persistence.createEntityManagerFactory("openmusic");
		manager = factory.createEntityManager();
	}

	public void Save(Musica obj) throws Exception{
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
	
	public void Delete(Musica obj) throws Exception{
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
	
	
	public Musica Open(int id) throws Exception{
		try{
			return manager.find(Musica.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName(){
		return manager.createQuery("select m from Musica m order by m.id")
		.setMaxResults(10).getResultList();
	}
	
	public List getByUsuario(int cod){
		return manager.createQuery("select m from Musica m join m.usuario u where u.id =:id")
		.setParameter("id", cod)
		.getResultList();
	}
}
