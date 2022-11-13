package br.com.percistencia.TrabalhoPratico02.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import br.com.percistencia.TrabalhoPratico02.Models.Ator;
import br.com.percistencia.TrabalhoPratico02.Models.Filme;

public class FilmeDAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Filmes-PU");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	//JPQL
	public void ListarFilmes() {
		String jpql = "select f from Filme f";
		TypedQuery<Filme> typedQueryFilmes = entityManager.createQuery(jpql, Filme.class);
		List<Filme> filmes = typedQueryFilmes.getResultList();
		
		for (Filme f : filmes) {
			System.out.println(f.toString());
		}
	}
	//NamedQuery
	public void RemoverFilme() {
		Query query = entityManager.createNamedQuery("Filmes.addFilme");
		
		entityManager.getTransaction().begin();
		query.setParameter("id", 99).executeUpdate();
		entityManager.getTransaction().commit();
	}
	
	public void AdicionarFilme(int id, String nome, int ano, List<Ator> atores) {
		
		Filme filme = new Filme();
		
		filme.setIdFilme(id);
		filme.setNomeFilme(nome);
		filme.setAnoDeLancamento(ano);
		filme.setAtores(atores);
		
		entityManager.getTransaction().begin();
		entityManager.persist(filme);
		entityManager.getTransaction().commit();
	}
	
	//Criteria Query
	public void AtualizarFilme(int id, String nome, int ano){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Filme> update = criteriaBuilder.createCriteriaUpdate(Filme.class);
		
		Root<Filme> e = update.from(Filme.class);
		
		update.set("tituloFilme",nome);
		update.set("anoDeLancamento", ano);
		
		update.where(criteriaBuilder.equal(e.get("idFilme"),id));
		
		entityManager.getTransaction().begin();
		entityManager.createQuery(update).executeUpdate();
		entityManager.getTransaction().commit();
	}
}
