package org.fstt.lsi.thymeleaf.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRAISON")
public class Livraison {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_liv;
	private String date_liv;
	
	@OneToMany(mappedBy="livraison")
	private Collection<Ligne_liv> lignes_liv;
	
	@ManyToOne
	@JoinColumn(name="CODE_FOUR")
	private Fournisseur fournisseur;
	
	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livraison(String date_liv, Fournisseur fournisseur) {
		super();
		this.date_liv = date_liv;
		this.fournisseur = fournisseur;
	}

	public int getNum_liv() {
		return num_liv;
	}

	public void setNum_liv(int num_liv) {
		this.num_liv = num_liv;
	}

	public String getDate_liv() {
		return date_liv;
	}

	public void setDate_liv(String date_liv) {
		this.date_liv = date_liv;
	}

	
	public Fournisseur getFournisseur() {
		return fournisseur;
	}



	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}



	@Override
	public String toString() {
		return "Livraison [num_liv=" + num_liv + ", date_liv=" + date_liv + ", fournisseur=" + fournisseur + "]";
	}




	
}
