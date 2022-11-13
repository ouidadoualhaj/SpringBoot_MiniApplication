package org.fstt.lsi.thymeleaf;

import java.util.List;

import org.fstt.lsi.thymeleaf.dao.ClientRepository;
import org.fstt.lsi.thymeleaf.dao.CommandeRepository;
import org.fstt.lsi.thymeleaf.dao.FournisseurRepository;
import org.fstt.lsi.thymeleaf.dao.Ligne_cmdRepository;
import org.fstt.lsi.thymeleaf.dao.Ligne_livRepository;
import org.fstt.lsi.thymeleaf.dao.LivraisonRepository;
import org.fstt.lsi.thymeleaf.dao.ProduitRepository;
import org.fstt.lsi.thymeleaf.dao.SocieteRepository;
import org.fstt.lsi.thymeleaf.entities.Client;
import org.fstt.lsi.thymeleaf.entities.Commande;
import org.fstt.lsi.thymeleaf.entities.Fournisseur;
import org.fstt.lsi.thymeleaf.entities.Ligne_cmd;
import org.fstt.lsi.thymeleaf.entities.Ligne_liv;
import org.fstt.lsi.thymeleaf.entities.Livraison;
import org.fstt.lsi.thymeleaf.entities.Produit;
import org.fstt.lsi.thymeleaf.entities.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class MyCatalogueApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private Ligne_cmdRepository ligne_cmdRepository;
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private Ligne_livRepository ligne_livRepository;
	@Autowired
	private LivraisonRepository livraisonRepository;
	@Autowired
	private SocieteRepository societeRepository;


	public static void main(String[] args) {
		SpringApplication.run(MyCatalogueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//produitRepository.save(new Produit("TV MODEL 2021", 6500, 154));
		//clientRepository.save(new Client("ahmed","ahmed", "tanger city","0682522783","Tanger"));
		//commandeRepository.save(new Commande(3,"2/2022"));
		//ligne_cmdRepository.save(new Ligne_cmd(1,4));
	    //fournisseurRepository.save(new Fournisseur("ali","rabat","064567867"));
		//ligne_livRepository.save(new Ligne_liv(76));
		//livraisonRepository.save(new Livraison("12/12/2022"));
		//societeRepository.save(new Societe("societe2","0508765","0645678","fes"));
		
		

	}
}