package org.fstt.lsi.thymeleaf.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FOURNISSEUR")
public class Fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code_four;
	private String nom_four;
	private String ville_four;
	private String tel_four;
	
	@OneToMany(mappedBy="fournisseur")
	private Collection<Livraison> livraisons;
	
	@OneToMany(mappedBy="fournisseur")
	private Collection<Societe> societes;
	
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fournisseur( String nom_four, String ville_four, String tel_four) {
		super();
		
		this.nom_four = nom_four;
		this.ville_four = ville_four;
		this.tel_four = tel_four;
	}

	@Override
	public String toString() {
		return "Fournisseur [code_four=" + code_four + ", nom_four=" + nom_four + ", ville_four=" + ville_four
				+ ", tel_four=" + tel_four + "]";
	}

	public int getCode_four() {
		return code_four;
	}

	public void setCode_four(int code_four) {
		this.code_four = code_four;
	}

	public String getNom_four() {
		return nom_four;
	}

	public void setNom_four(String nom_four) {
		this.nom_four = nom_four;
	}

	public String getVille_four() {
		return ville_four;
	}

	public void setVille_four(String ville_four) {
		this.ville_four = ville_four;
	}

	public String getTel_four() {
		return tel_four;
	}

	public void setTel_four(String tel_four) {
		this.tel_four = tel_four;
	}
	
	
	
	
}
