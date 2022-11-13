package org.fstt.lsi.thymeleaf.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "LIGNE_LIV")
public class Ligne_liv {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_ligne;
	private int qte_liv;
	
	@ManyToOne
	@JoinColumn(name="CODE_ART")
	private Produit article;
	
	@ManyToOne
	@JoinColumn(name="NUM_LIV")
	private Livraison livraison;
	
	public Ligne_liv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ligne_liv(int num_ligne, int qte_liv, Produit article, Livraison livraison) {
		super();
		this.num_ligne = num_ligne;
		this.qte_liv = qte_liv;
		this.article = article;
		this.livraison = livraison;
	}


	public int getNum_ligne() {
		return num_ligne;
	}

	public void setNum_ligne(int num_ligne) {
		this.num_ligne = num_ligne;
	}

	public int getQte_liv() {
		return qte_liv;
	}

	public void setQte_liv(int qte_liv) {
		this.qte_liv = qte_liv;
	}

	public Produit getArticle() {
		return article;
	}

	public void setArticle(Produit article) {
		this.article = article;
	}

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

	@Override
	public String toString() {
		return "Ligne_liv [num_ligne=" + num_ligne + ", qte_liv=" + qte_liv + ", article=" + article + ", livraison="
				+ livraison + "]";
	}

	

	
	
	
}
