package dataAccess;

import domainModel.Solicitacao;

import java.util.List;

import javax.persistence.*;

public class SolicitacaoRepository {
	
	private EntityManager maneger;
	private EntityManagerFactory factory;
	private EntityTransaction transaction;
	
	public SolicitacaoRepository(){
		factory = Persistence.createEntityManagerFactory("openmusic");
		maneger = factory.createEntityManager();
	}
	
	public void Save(Solicitacao obj) throws Exception{
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
	public void Delete(Solicitacao obj) throws Exception{
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
	
	
	public Solicitacao Open(int id) throws Exception{
		try{
			return maneger.find(Solicitacao.class, id);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTop10ByName(){
		return maneger.createQuery("select u from Solicitacao u order by u.id")
		.setMaxResults(10).getResultList();
	}
	
	public Solicitacao getByUsuario(int cod1, int cod2){
		return (Solicitacao)maneger.createQuery("select s from Solicitacao s join idsolicitado u join idsolicitador us where u.id = :id1 and us.id = :id2")
		.setParameter("id1", cod1)
		.setParameter("id2", cod2)
		.getSingleResult();
	}
	
	public List getBySolicitacao(int cod){
		return maneger.createQuery("select s from Solicitacao s join idsolicitado u where u.id = :id")
		.setParameter("id", cod)
		.getResultList();
	}

}
