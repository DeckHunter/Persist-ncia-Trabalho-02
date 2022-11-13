package br.com.percistencia.TrabalhoPratico02.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Filmes.addFilme", query = "DELETE FROM Filme f WHERE f.idFilme = :id")
@Table(name = "Filmes")
public class Filme {

	@Id
	@Column(name = "idFilme")
	private Integer idFilme; 
	
	@Column(name = "tituloFilme")
	private String tituloFilme;
	
	@Column(name = "anoDeLancamento")
	private int anoDeLancamento;
	
	@ManyToMany
	@JoinTable(name = "FILME_ATOR", joinColumns = @JoinColumn(name="filmeId"), inverseJoinColumns = @JoinColumn(name="atorId"))
	private List<Ator> atores;

	public Filme(Integer idFilme, String tituloFilme, int anoDeLancamento, List<Ator> atores) {
		super();
		this.idFilme = idFilme;
	 	this.tituloFilme = tituloFilme;
		this.anoDeLancamento = anoDeLancamento;
		this.atores = atores;
	}

	public Filme() {
		super();
	}

	@Override
	public String toString() {
		return "Filme "+ "  \n" + " idFilme = " + idFilme + "  \n" + " nomeFilme = " + tituloFilme + "  \n" + " anoDeLancamento = " + anoDeLancamento + "  \n" + " ";
	}
	
	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	public Integer getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
	}
	public String getNomeFilme() {
		return tituloFilme;
	}
	public void setNomeFilme(String nomeFilme) {
		this.tituloFilme = nomeFilme;
	}
	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}
	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}
	
}
