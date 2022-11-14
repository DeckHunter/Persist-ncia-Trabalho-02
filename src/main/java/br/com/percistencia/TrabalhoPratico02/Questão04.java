package br.com.percistencia.TrabalhoPratico02;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.percistencia.TrabalhoPratico02.Models.Ator;
import br.com.percistencia.TrabalhoPratico02.Models.Filme;

public class Questão04 {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Filmes-PU");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public void ItemA(String escolha, int id) {
		switch (escolha) {
			case "Ator":
				Ator ator = entityManager.find(Ator.class, id);
				if(ator != null) {
					System.out.println(ator.toString());
				}else {
					System.out.println("Ator não encontrado");
				}
				break;
			case "Filme":
				Filme filme = entityManager.find(Filme.class, id);
				
				if(filme != null) {
					System.out.println(filme.toString());
				}else {
					System.out.println("Filme não encontrado");
				}
				break;
			default:
				System.out.println("Escolha Invalida");
				break;
		}
	}
	public void ItemB(int id) {
		String jpql = "select f from Filme f";
		Ator atorEscolhido = entityManager.find(Ator.class, id);
		
		TypedQuery<Filme> typedQueryFilmes = entityManager.createQuery(jpql, Filme.class);
		List<Filme> filmes = typedQueryFilmes.getResultList();
		
		if(atorEscolhido != null) {
			for (Filme filme : filmes) {
				if(filme.getAtores() != null) {
					for (Ator ator : filme.getAtores()) {					
						if(atorEscolhido.getIdAtor() == ator.getIdAtor()) {
							System.out.println(filme.getNomeFilme());
						}
					}
				}else {
					System.out.println("Esse ator ainda não tem filmes ");
				}
			}
		}else {
			System.out.println("Ator não encontrado");
		}
		
	}
	public void ItemC(int id) {
		String jpql = "select a from Ator a";
		Filme filmeEscolhido = entityManager.find(Filme.class, id);
			
		if(filmeEscolhido != null) {	
			if(filmeEscolhido.getAtores().size() > 0) {
				System.out.println("Elenco do Filme");
				for (Ator a : filmeEscolhido.getAtores()) {
					System.out.println(a.getNomeAtor());
				}
			}else {
				System.out.println("Filme não tem elenco cadastrado");
			}
		}else {
			System.out.println("Filme não encontrado");
		}
	}
	public void ItemD(int ano) {
		String jpql = "select f from Filme f where anoDeLancamento = " + ano;
		TypedQuery<Filme> typedQueryFilmes = entityManager.createQuery(jpql, Filme.class);
		
		List<Filme> filmes = typedQueryFilmes.getResultList();	
		
		if(filmes.size() > 0) { 
			System.out.println("Filmes Lançados Em "+ano);
			for (Filme f : filmes) {
				System.out.println(f.getNomeFilme());
			}
		}else {
			System.out.println("Não teve nenhum filme lancado em "+ano);
		}
	}
	public void ItemE(String s) {
		String jpql = "select f from Filme f";
		TypedQuery<Filme> typedQueryFilmes = entityManager.createQuery(jpql, Filme.class);
		List<Filme> filmes = typedQueryFilmes.getResultList();	
		
		if(filmes.size() > 0) { 
			for (Filme f : filmes) {
				if((f.getNomeFilme().toUpperCase()).contains(s.toUpperCase())) {
					System.out.println(f.getNomeFilme());
				}
			}
		}else {
			System.out.println("Não teve nenhum filme lancado com a palavra "+s);
		}
	}
	public void ItemF(int ano) {
		String jpql = "select a from Ator a";
		TypedQuery<Ator> typedQueryAtores = entityManager.createQuery(jpql, Ator.class);
		List<Ator> atores = typedQueryAtores.getResultList();
		List<String> atoresAno = new ArrayList<String>();
		
		for (Ator ator : atores) {
			if(ano == Integer.parseInt(ator.getDataDeNascimento().split("-")[0])){
				atoresAno.add(ator.getNomeAtor());
			}
		}
		if(atoresAno.size() > 0) {
			System.out.println("Atores nascidos em "+ano);
			for (String string : atoresAno) {
				System.out.println(string);
			}
		}else {
			System.out.println("Não tem atores nascidos em "+ano);
		}
	}
	public void ItemG() {
		String jpql = "select f from Filme f";
		TypedQuery<Filme> typedQueryFilmes = entityManager.createQuery(jpql, Filme.class);
		List<Filme> filmes = typedQueryFilmes.getResultList();	
		
		System.out.println("Quantidade De Filmes Cadastrados : " + filmes.size());
	}
	
	
}
