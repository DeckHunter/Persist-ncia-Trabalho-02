package br.com.percistencia.TrabalhoPratico02;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.percistencia.TrabalhoPratico02.Models.Ator;
import br.com.percistencia.TrabalhoPratico02.Models.Filme;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Filmes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Filme filme = new Filme();
		Ator ator1 = new Ator(1, "Alex", "1999/12/12", null);
		Ator ator2 = new Ator(3, "Maria", "2012/11/11", null);
		
		List<Ator> atores = new ArrayList<Ator>();
		
		atores.add(ator1);
		atores.add(ator2);

		System.out.println(ator1.toString());
		System.out.println(ator2.toString());
		
		filme.setIdFilme(23);
		filme.setNomeFilme("Aventura De Outro Mundo");
		filme.setAnoDeLancamento(2018);
		filme.setAtores(atores);
		
		entityManager.getTransaction().begin();
		entityManager.persist(ator1);
		entityManager.persist(ator2);
		entityManager.persist(filme);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		  
	}

}
