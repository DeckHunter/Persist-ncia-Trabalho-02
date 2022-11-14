package br.com.percistencia.TrabalhoPratico02;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.percistencia.TrabalhoPratico02.DAO.AtorDAO;
import br.com.percistencia.TrabalhoPratico02.DAO.FilmeDAO;
import br.com.percistencia.TrabalhoPratico02.Models.Ator;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Filmes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		AtorDAO atorDAO = new AtorDAO();
		FilmeDAO filmeDAO = new FilmeDAO();
		Questão04 questão04 = new Questão04();
		
		//Ator ator1 = new Ator(6, "Davi", "1999/12/12", null);
		//Ator ator2 = new Ator(5, "Katarina", "2012/11/11", null);
		
		List<Ator> atores = new ArrayList<Ator>();
		
		questão04.ItemA("Ator", 2);
		questão04.ItemB(398);
		questão04.ItemC(13);
		questão04.ItemD(1111);
		questão04.ItemE("dd");
		questão04.ItemF(1994);
		questão04.ItemG();
		
		System.out.println("Quer Adicionar Um Elenco (S/N) ? : ");
		Scanner sc = new Scanner(System.in);
		String resposta = sc.next();
		
		if(resposta.equals("S")) {
			System.out.println("Entrou No IF Sim");
		    System.out.print("Digite os IDs dos atores que estão no filme sepados por '-' : ");
		    String idsAtores = sc.next();
		    
		    for (String s : idsAtores.split("-")) {
				Ator ator = entityManager.find(Ator.class, Integer.parseInt(s));
				atores.add(ator);
			}
		    
		    for (Ator ator : atores) {
				System.out.println(ator.toString());
			}
		    
		    filmeDAO.AdicionarFilme(999, "Vou 171" ,2023, atores);
		    
		}if(resposta.equals("N")) {
			filmeDAO.AdicionarFilme(1000, "Deus e vc" ,2023, atores);
		}
		
		//atorDAO.ListarAtore();
		//filmeDAO.ListarFilmes();
		
		//filmeDAO.RemoverFilme();
		//atorDAO.RemoverAtor();
		
		
		//atorDAO.AdicionarAtor();
		//filmeDAO.AtualizarFilme(13, "The Deus", 2002);
		//atorDAO.AtualizarAtor(5, "João", "1999/10/21");
		entityManager.close();
		entityManagerFactory.close();
		  
	}

}
