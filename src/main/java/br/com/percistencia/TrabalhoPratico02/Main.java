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
				opCrudAtor = "s";
				while(!opCrudAtor.equals("0")) {
					System.out.println("");
					MenuAtorCRUD();
					System.out.println("Selecione Uma Opção : ");
					System.out.println("");
					opCrudAtor = s.nextLine();
			  	    System.out.println("");
					switch (opCrudAtor) {
					case "0":
						MenuPrincipal();
						break;
					case "1":
						System.out.println("ID Do Ator : ");
						String filmeaddId = s.nextLine();
						System.out.println("Nome Do Ator : ");
						String filmeaddNome = s.nextLine();
						System.out.println("Data De Nascimento Do Ator(Ex: 2001/01/01) : ");
						String filmeaddData = s.nextLine();
						
						atorDAO.AdicionarAtor(Integer.parseInt(filmeaddId), filmeaddNome, filmeaddData);
						break;
					case "2":
						System.out.println("Id Do Ator Que Vai Ser Deletado : ");
						String atorRemover = s.nextLine();
						atorDAO.RemoverAtor(Integer.parseInt(atorRemover));
						
						break;
					case "3":
						System.out.println("Id Do Ator Que Vai Ser Atualizado : ");
						String atorUpid = s.nextLine();
						System.out.println("Nome Do Ator Que Vai Ser Atualizado : ");
						String atorUpnome = s.nextLine();
						System.out.println("Data Do Ator Que Vai Ser Atualizado : ");
						String atorUpdata = s.nextLine();
						atorDAO.AtualizarAtor(Integer.parseInt(atorUpid), atorUpnome, atorUpdata);
						break;
					case "4":
						atorDAO.ListarAtore();
						break;
					default:
						System.out.println("Opção Invalida");
						break;
					}
				}
				break;
			case "2":
		  	    opCrudFilme = "s";
				while(!opCrudFilme.equals("0")) {
					
					System.out.println("");
					MenuFilmeCRUD();
					System.out.println("Selecione Uma Opção : ");
					System.out.println("");
			  	    opCrudFilme = s.nextLine();
			  	    System.out.println("");
			  	    
					switch (opCrudFilme) {
					case "0":
						MenuPrincipal();
						break;
					case "1":
						System.out.println("");
						System.out.println("ID Do Filme : ");
						String idFilme = s.nextLine();
						System.out.println("Nome Do Filme : ");
						String nomeFilme = s.nextLine();
						System.out.println("Ano De Lancamento Do Filme : ");
						String anoFilme = s.nextLine();
						
						System.out.println("Quer Adicionar Um Elenco (S/N) ? : ");
						Scanner sc = new Scanner(System.in);
						String resposta = sc.next();
						List<Ator> atores = new ArrayList<Ator>();
						
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
						    
						    filmeDAO.AdicionarFilme(Integer.parseInt(idFilme), nomeFilme ,Integer.parseInt(anoFilme), atores);
						    
						}if(resposta.equals("N")) {
							filmeDAO.AdicionarFilme(Integer.parseInt(idFilme), nomeFilme ,Integer.parseInt(anoFilme), atores);
						};
						System.out.println("");
						break;
					case "2":
						System.out.println("Id Do Filme Que Vai Ser Deletado : ");
						String filmeRemover = s.nextLine();
						filmeDAO.RemoverFilme(Integer.parseInt(filmeRemover));
						break;
					case "3":
						System.out.println("Id Do Ator Que Vai Ser Atualizado : ");
						String filmeUpid = s.nextLine();
						System.out.println("Nome Do Ator Que Vai Ser Atualizado : ");
						String filmeUpnome = s.nextLine();
						System.out.println("Data Do Ator Que Vai Ser Atualizado : ");
						String filmeUpano = s.nextLine();
						filmeDAO.AtualizarFilme(Integer.parseInt(filmeUpid), filmeUpnome, Integer.parseInt(filmeUpano));
						break;
					case "4":
						filmeDAO.ListarFilmes();
						break;
					default:
						System.out.println("Opção Invalida");
						break;
					}
				}
				break;
			case "3":
				opQuestão04 = "s";
				while(!opQuestão04.equals("0")) {
					
					System.out.println("");
					MenuQuestão04();
					System.out.println("Selecione Uma Opção : ");
					System.out.println("");
					opQuestão04 = s.nextLine();
			  	    System.out.println("");
			  	    
					switch (opQuestão04) {
						case "0":
							MenuPrincipal();
							break;
						case "a":
							System.out.println("Digite 'Ator' ou 'Filme' : ");
							String itemaEscolha = s.nextLine();
							System.out.println("Digite o ID do Filme/Ator : ");
							String itema = s.nextLine();
							System.out.println("");
							questão04.ItemA(itemaEscolha, Integer.parseInt(itema));
							break;
						case "b":
							System.out.println("Digite o Id : ");
							System.out.println("");
							String itemb = s.nextLine();
					  	    System.out.println("");
							questão04.ItemB(Integer.parseInt(itemb));
							break;
						case "c":
							System.out.println("Digite o Id : ");
							System.out.println("");
							String itemc = s.nextLine();
					  	    System.out.println("");
							questão04.ItemC(Integer.parseInt(itemc));
							break;
						case "d":
							System.out.println("Digite o ano : ");
							System.out.println("");
							String itemd = s.nextLine();
					  	    System.out.println("");
							questão04.ItemD(Integer.parseInt(itemd));
							break;
						case "e":
							System.out.println("Digite a palavra : ");
							System.out.println("");
							String iteme = s.nextLine();
					  	    System.out.println("");
							questão04.ItemE(iteme);
							break;
						case "f":
							System.out.println("Digite o Ano : ");
							System.out.println("");
							String itemf = s.nextLine();
					  	    System.out.println("");
							questão04.ItemF(Integer.parseInt(itemf));
							break;
						case "g":
							questão04.ItemG();
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
