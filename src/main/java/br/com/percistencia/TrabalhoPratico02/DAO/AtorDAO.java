package br.com.percistencia.TrabalhoPratico02.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import br.com.percistencia.TrabalhoPratico02.Models.Ator;
import br.com.percistencia.TrabalhoPratico02.Models.Filme;

public class AtorDAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Filmes-PU");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	//JPQL
	public void ListarAtore() {
		String jpql = "select a from Ator a";
		
		TypedQuery<Ator> typedQueryAtores = entityManager.createQuery(jpql, Ator.class);
		List<Ator> atores = typedQueryAtores.getResultList();
		
		for (Ator a : atores) {
			System.out.println(a.toString());
		}
	}
	//NamedQuery
	public void RemoverAtor() {
		Query query = entityManager.createNamedQuery("Ator.addFilme");
		
		entityManager.getTransaction().begin();
		query.setParameter("id", 63).executeUpdate();	
		entityManager.getTransaction().commit();
	}
	
	//Native Query
	public void AdicionarAtor(int id, String nome, String data) {
		Query query = entityManager.createNativeQuery("INSERT INTO Ator (idAtor,nomeAtor,dataDeNascimento) VALUES ( ? ,  ? , ?)");
		entityManager.getTransaction().begin();
		query.setParameter(1, id);
		query.setParameter(2, nome);
		query.setParameter(3, data);
		query.executeUpdate();
		entityManager.getTransaction().commit();
	}
	
	//Criteria Query
	public void AtualizarAtor(int id, String nome, String data){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Ator> update = criteriaBuilder.createCriteriaUpdate(Ator.class);
		
		Root<Ator> e = update.from(Ator.class);
		
		update.set("nomeAtor",nome);
		update.set("dataDeNascimento", data);
		
		update.where(criteriaBuilder.equal(e.get("idAtor"),id));
		
		entityManager.getTransaction().begin();
		entityManager.createQuery(update).executeUpdate();
		entityManager.getTransaction().commit();
	}
}
