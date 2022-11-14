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
		
		String op = "";
		Scanner s = new Scanner(System.in);
		
		String opCrudAtor = "";
		String opCrudFilme = "";
		String opQuestão04 = "";

		while(!op.equals("0")) {
			
			System.out.println("");
			MenuPrincipal();
			System.out.println("");
			System.out.println("Selecione Uma Opção : ");
	    	System.out.println("");
	  	    op = s.nextLine();
	  	    System.out.println("");
	  	     	  	  
			switch (op) {
			case "0":
				System.out.println("");
				System.out.println("Projeto Finalizado...");
				break;
			case "1":
				MenuAtorCRUD();
				System.out.println("");
				System.out.println("Selecione Uma Opção : ");
				System.out.println("");
		  	    opCrudFilme = s.nextLine();
		  	    System.out.println("");
				while(!opCrudFilme.equals("0")) {
					switch (opCrudFilme) {
					case "0":
						MenuPrincipal();
						break;
					case "1":
						System.out.println("Add");
						break;
					case "2":
						System.out.println("Delete");
						break;
					case "3":
						System.out.println("Update");
						break;
					case "4":
						System.out.println("Read");
						break;
					default:
						System.out.println("Opção Invalida");
						break;
					}
				}
				break;
			case "2":
				MenuFilmeCRUD();
				System.out.println("");
				System.out.println("Selecione Uma Opção : ");
				System.out.println("");
		  	    opCrudFilme = s.nextLine();
		  	    System.out.println("");
				while(!opCrudFilme.equals("0")) {
					switch (opCrudFilme) {
					case "0":
						MenuPrincipal();
						break;
					case "1":
						System.out.println("Add");
						break;
					case "2":
						System.out.println("Delete");
						break;
					case "3":
						System.out.println("Update");
						break;
					case "4":
						System.out.println("Read");
						break;
					default:
						System.out.println("Opção Invalida");
						break;
					}
				}
				break;
			case "3":
				MenuQuestão04();
				System.out.println("");
				System.out.println("Selecione Uma Opção : ");
				System.out.println("");
				opQuestão04 = s.nextLine();
		  	    System.out.println("");
				while(!opQuestão04.equals("0")) {
					switch (opQuestão04) {
					case "0":
						MenuPrincipal();
						break;
					case "a":
						System.out.println("A");
						break;
					case "b":
						System.out.println("B");
						break;
					case "c":
						System.out.println("C");
						break;
					case "d":
						System.out.println("D");
						break;
					case "e":
						System.out.println("E");
						break;
					case "f":
						System.out.println("F");
						break;
					case "g":
						System.out.println("G");
						break;
					default:
						System.out.println("Opção Invalida");
						break;
					}
				}
				break;

			default:
				System.out.println("Opção Invalida");
				break;
			}
		}
		
		List<Ator> atores = new ArrayList<Ator>();
		
		questão04.ItemA("Ator", 2);
		questão04.ItemB(398);
		questão04.ItemC(13);
		questão04.ItemD(1111);
		questão04.ItemE("dd");
		questão04.ItemF(1994);
		questão04.ItemG();
		
		/*System.out.println("Quer Adicionar Um Elenco (S/N) ? : ");
		Scanner sc = new Scanner(System.in);
		String resposta = sc.next();
		
		if(resposta.equals("S")) {
		    System.out.print("Digite os IDs dos atores que estão no filme sepados por '-' : ");
		    String idsAtores = sc.next();
		    
		    for (String string : idsAtores.split("-")) {
				Ator ator = entityManager.find(Ator.class, Integer.parseInt(string));
				atores.add(ator);
			}
		    
		    for (Ator ator : atores) {
				System.out.println(ator.toString());
			}
		    
		    filmeDAO.AdicionarFilme(999, "Vou 171" ,2023, atores);
		    
		}if(resposta.equals("N")) {
			filmeDAO.AdicionarFilme(1000, "Deus e vc" ,2023, atores);
		}*/
		
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
	
	public static void MenuPrincipal(){
		System.out.println("1 - CRUD Ator");
		System.out.println("2 - CRUD Filme");
		System.out.println("3 - Questão 04");
		System.out.println("0 - Sair");	
	}
	public static void MenuFilmeCRUD(){
		System.out.println("1 - Adiciona Filme");
		System.out.println("2 - Remover Filme");
		System.out.println("3 - Atualizar Filme");
		System.out.println("4 - Listar Filmes");
		System.out.println("0 - Voltar");
	}
	public static void MenuAtorCRUD(){
		System.out.println("1 - Adiciona Ator");
		System.out.println("2 - Remover Ator");
		System.out.println("3 - Atualizar Ator");
		System.out.println("4 - Listar Atores");
		System.out.println("0 - Voltar");
	}
	public static void MenuQuestão04() {
		System.out.println("a - Obter ator e filme a partir de seus respectivos ids");
		System.out.println("b - Listar todos os títulos de filmes de um determinado ator");
		System.out.println("c - Listar os nomes de todos os atores de um determinado filme");
		System.out.println("d - Listar os títulos de filmes lançados em determinado ano");
		System.out.println("e - Listar os títulos de filmes cujo título contém determinada string");
		System.out.println("f - Listar os nomes de atores nascidos em determinado ano");
		System.out.println("g - Mostrar a quantidade total de filmes cadastrados");
		System.out.println("0 - Voltar");
	}
}
