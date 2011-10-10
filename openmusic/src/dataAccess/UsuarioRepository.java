package dataAccess;

import domainModel.Usuario;

import java.util.List;

import javax.persistence.*;


public class UsuarioRepository {
	
	private EntityManager manager;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public UsuarioRepository(){
		factory = Persistence.createEntityManagerFactory("openmusic");
		manager = factory.createEntityManager();
	}
	
	public void Save(Usuario obj) throws Exception{
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
	public void Delete(Usuario obj) throws Exception{
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
	
	
	public Usuario Open(int id) throws Exception{
		try{
			return manager.find(Usuario.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName(){
		return manager.createQuery("select u from Usuario u order by u.nome")
		.setMaxResults(10).getResultList();
	}
	
	public List getTop10ByName(String busca){
		try{
			return manager.createQuery("select u from Usuario u where u.nome = :b")
			.setParameter("b", busca)
			.setMaxResults(10).getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		return null;
	}
	
	public Usuario OpenByLogin(String usuario){
		try{
			return (Usuario) manager.createQuery("select u from Usuario u where u.email =:log")
			.setParameter("log", usuario)
			.getSingleResult();		 
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	

}
