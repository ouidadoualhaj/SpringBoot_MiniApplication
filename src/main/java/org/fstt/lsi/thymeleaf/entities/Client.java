package org.fstt.lsi.thymeleaf.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code_cli;
	private String nom_cli;
	private String pre_cli;
	private String adr_cli;
	private String tel_cli;
	private String ville_cli;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Commande> commandes;
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Client(String nom_cli, String pre_cli, String adr_cli, String tel_cli, String ville_cli) {
		super();
		this.nom_cli = nom_cli;
		this.pre_cli = pre_cli;
		this.adr_cli = adr_cli;
		this.tel_cli = tel_cli;
		this.ville_cli = ville_cli;
	}




	@Override
	public String toString() {
		return "Client [code_cli=" + code_cli + ", nom_cli=" + nom_cli + ", pre_cli=" + pre_cli + ", adr_cli=" + adr_cli
				+ ", tel_cli=" + tel_cli + ", ville_cli=" + ville_cli + "]";
	}


	public int getCode_cli() {
		return code_cli;
	}
	public void setCode_cli(int code_cli) {
		this.code_cli = code_cli;
	}
	public String getNom_cli() {
		return nom_cli;
	}
	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}
	public String getPre_cli() {
		return pre_cli;
	}
	public void setPre_cli(String pre_cli) {
		this.pre_cli = pre_cli;
	}
	public String getAdr_cli() {
		return adr_cli;
	}
	public void setAdr_cli(String adr_cli) {
		this.adr_cli = adr_cli;
	}
	public String getTel_cli() {
		return tel_cli;
	}
	public void setTel_cli(String tel_cli) {
		this.tel_cli = tel_cli;
	}
	public String getVille_cli() {
		return ville_cli;
	}
	public void setVille_cli(String ville_cli) {
		this.ville_cli = ville_cli;
	}
	
	public Collection<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	
	
	
    
	
}