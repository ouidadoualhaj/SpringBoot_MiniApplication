package org.fstt.lsi.thymeleaf.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "LIGNE_CMD")
public class Ligne_cmd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_ligne;
	private int qte_cmd;
	
	@ManyToOne
	@JoinColumn(name="NUM_CMD")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name="CODE_ART")
	private Produit article;

	public Ligne_cmd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ligne_cmd(int num_ligne, int qte_cmd) {
		super();
		this.num_ligne = num_ligne;
		this.qte_cmd = qte_cmd;
	}

	public int getNum_ligne() {
		return num_ligne;
	}

	public void setNum_ligne(int num_ligne) {
		this.num_ligne = num_ligne;
	}

	public int getQte_cmd() {
		return qte_cmd;
	}

	public void setQte_cmd(int qte_cmd) {
		this.qte_cmd = qte_cmd;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getArticle() {
		return article;
	}

	public void setArticle(Produit article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Ligne_cmd [num_ligne=" + num_ligne + ", qte_cmd=" + qte_cmd + ", commande=" + commande + ", article="
				+ article + "]";
	}

	
	
	
	
}                                          

