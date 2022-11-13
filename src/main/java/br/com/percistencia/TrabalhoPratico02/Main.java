package br.com.percistencia.TrabalhoPratico02;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.percistencia.TrabalhoPratico02.DAO.AtorDAO;
import br.com.percistencia.TrabalhoPratico02.DAO.FilmeDAO;
import br.com.percistencia.TrabalhoPratico02.Models.Ator;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Filmes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		

		Ator ator1 = new Ator(6, "Davi", "1999/12/12", null);
		Ator ator2 = new Ator(5, "Katarina", "2012/11/11", null);
		
		List<Ator> atores = new ArrayList<Ator>();
		
		atores.add(ator1);
		atores.add(ator2);
		
		AtorDAO atorDAO = new AtorDAO();
		FilmeDAO filmeDAO = new FilmeDAO();
		
		atorDAO.ListarAtore();
		filmeDAO.ListarFilmes();
		
		//filmeDAO.RemoverFilme();
		//atorDAO.RemoverAtor();
		
		//filmeDAO.AdicionarFilme(123, "Quase Todo Mundo Vivo" ,2021, atores);
		//atorDAO.AdicionarAtor();
		//filmeDAO.AtualizarFilme(13, "The Deus", 2002);
		atorDAO.AtualizarAtor(5, "João", "1999/10/21");
		entityManager.close();
		entityManagerFactory.close();
		  
	}

}
