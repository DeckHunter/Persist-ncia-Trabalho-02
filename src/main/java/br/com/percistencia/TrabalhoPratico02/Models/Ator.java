package br.com.percistencia.TrabalhoPratico02.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ator")
public class Ator {

	@Id
	@Column(name = "idAtor")
	private Integer idAtor;
	
	@Column(name = "nomeAtor")
	private String nomeAtor;
	
	@Column(name = "dataDeNascimento")
	private String dataDeNascimento;
	
	@ManyToMany(mappedBy = "atores")
	private List<Filme> filmes;
	
	public Ator(Integer idAtor, String nomeAtor, String dataDeNascimento, List<Filme> filmes) {
		super();
		this.idAtor = idAtor;
		this.nomeAtor = nomeAtor;
		this.dataDeNascimento = dataDeNascimento;
		this.filmes = filmes;
	}

	public Ator() {
		super();
	}

	@Override
	public String toString() {
		return "Ator " + "  \n" + " idAtor = " + idAtor + "  \n" + " nomeAtor = " + nomeAtor + "  \n" + " dataDeNascimento = " + dataDeNascimento + "  \n" + " ";
	}
	
	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public Integer getIdAtor() {
		return idAtor;
	}
	public void setIdAtor(Integer idAtor) {
		this.idAtor = idAtor;
	}
	public String getNomeAtor() {
		return nomeAtor;
	}
	public void setNomeAtor(String nomeAtor) {
		this.nomeAtor = nomeAtor;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	
}
