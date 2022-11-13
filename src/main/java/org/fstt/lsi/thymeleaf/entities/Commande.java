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
@Table(name = "COMMANDE")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_cmd;
	private String date_cmd;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	
	@OneToMany(mappedBy="commande")
	private Collection<Ligne_cmd> lignes_cmd;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}


	



	public Commande(int num_cmd, String date_cmd, Client client) {
		super();
		this.num_cmd = num_cmd;
		this.date_cmd = date_cmd;
		this.client = client;
	}






	public int getNum_cmd() {
		return num_cmd;
	}

	public void setNum_cmd(int num_cmd) {
		this.num_cmd = num_cmd;
	}

	public String getDate_cmd() {
		return date_cmd;
	}

	public void setDate_cmd(String date_cmd) {
		this.date_cmd = date_cmd;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Commande [num_cmd=" + num_cmd + ", date_cmd=" + date_cmd + ", client=" + client + "]";
	}
	
	
}                                          

