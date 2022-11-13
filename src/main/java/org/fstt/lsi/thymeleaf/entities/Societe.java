package org.fstt.lsi.thymeleaf.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SOCIETE")
public class Societe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code_ste;
	private String nom_ste;
	private String tel_ste;
	private String fax_ste;
	private String ville_ste;
	
	@ManyToOne
	@JoinColumn(name="CODE_FOUR")
	private Fournisseur fournisseur;

	
	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Societe(String nom_ste, String tel_ste, String fax_ste, String ville_ste, Fournisseur fournisseur) {
		super();
		this.nom_ste = nom_ste;
		this.tel_ste = tel_ste;
		this.fax_ste = fax_ste;
		this.ville_ste = ville_ste;
		this.fournisseur = fournisseur;
	}

	public int getCode_ste() {
		return code_ste;
	}

	public void setCode_ste(int code_ste) {
		this.code_ste = code_ste;
	}

	public String getNom_ste() {
		return nom_ste;
	}

	public void setNom_ste(String nom_ste) {
		this.nom_ste = nom_ste;
	}

	public String getTel_ste() {
		return tel_ste;
	}

	public void setTel_ste(String tel_ste) {
		this.tel_ste = tel_ste;
	}

	public String getFax_ste() {
		return fax_ste;
	}

	public void setFax_ste(String fax_ste) {
		this.fax_ste = fax_ste;
	}

	public String getVille_ste() {
		return ville_ste;
	}

	public void setVille_ste(String ville_ste) {
		this.ville_ste = ville_ste;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Override
	public String toString() {
		return "Societe [code_ste=" + code_ste + ", nom_ste=" + nom_ste + ", tel_ste=" + tel_ste + ", fax_ste="
				+ fax_ste + ", ville_ste=" + ville_ste + ", fournisseur=" + fournisseur + "]";
	}

	
	
	
	
}
