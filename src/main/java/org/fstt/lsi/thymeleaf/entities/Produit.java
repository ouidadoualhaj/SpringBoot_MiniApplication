package org.fstt.lsi.thymeleaf.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUIT")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code_art;
	private String nom_art;
	private float pu;
	private float qte_stock;
	
	//un article peut appartenir à plusieurs lignes de commande
	@OneToMany(mappedBy="article")
	private Collection<Ligne_cmd> lignes_cmd;	
	
	//un article peut appartenir à plusieurs lignes de commande
	@OneToMany(mappedBy="article")
	private Collection<Ligne_liv> lignes_liv;
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Produit(String nom_art, float pu, float qte_stock) {
		super();
		this.nom_art = nom_art;
		this.pu = pu;
		this.qte_stock = qte_stock;
	}
	
	public int getCode_art() {
		return code_art;
	}
	public void setCode_art(int code_art) {
		this.code_art = code_art;
	}
	public String getNom_art() {
		return nom_art;
	}
	public void setNom_art(String nom_art) {
		this.nom_art = nom_art;
	}
	public float getPu() {
		return pu;
	}
	public void setPu(float pu) {
		this.pu = pu;
	}
	public float getQte_stock() {
		return qte_stock;
	}
	public void setQte_stock(float qte_stock) {
		this.qte_stock = qte_stock;
	}
	@Override
	public String toString() {
		return "Produit [code_art=" + code_art + ", nom_art=" + nom_art + ", pu=" + pu + ", qte_stock=" + qte_stock
				+ "]";
	}

    
}