package org.fstt.lsi.thymeleaf.web;

import java.util.List;

import org.fstt.lsi.thymeleaf.dao.CommandeRepository;
import org.fstt.lsi.thymeleaf.entities.Client;
import org.fstt.lsi.thymeleaf.entities.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommandeController {

	@Autowired
	private CommandeRepository commandeRepository;
	
	//affiches les commandes
	@GetMapping(path="/commandes")
	public String commandes(Model model) {
		List<Commande> commandes=commandeRepository.findAll();
		model.addAttribute("listeCommandes",commandes);
		return "commandes";
	}
	
	//supprimer une ligne de commande
	@GetMapping(path = "/deleteCommande")
		private String delete(int id, String motCle, String page, String size) {
		commandeRepository.deleteById(id);
		return "redirect:/commandes?page=" + page + "&motCle=" + motCle + "&size=" + size;
	}
	
	//ajouter une commande
		@GetMapping(path = "/commande/new")
		private String createCommandeForm(Model model) {
			Commande commande=new Commande();
			model.addAttribute("commande",commande);
			return "create_commande";
		}
		
		@PostMapping(path="/commande/save")
		private String saveCommande(@ModelAttribute("commande")Commande cmd) {
			commandeRepository.save(cmd);
			return "redirect:/commandes";
		}
		
		@GetMapping("/commandes/edit/{id}")
		public String editCommandeForm(@PathVariable int id, Model model) {
			model.addAttribute("commande", commandeRepository.findById(id).get());
			return "update_commande";
		}

		@PostMapping("/commandes/{id}")
		public String updateCommande(@PathVariable int id,
				@ModelAttribute("commande") Commande commande,
				Model model) {
			
			// get student from database by id
			Commande existingCommande = commandeRepository.findById(id).get();
			existingCommande.setNum_cmd(id);
			existingCommande.setDate_cmd(commande.getDate_cmd());
			existingCommande.setClient(commande.getClient());
			
			// save updated student object
			commandeRepository.save(existingCommande);
			return "redirect:/commandes";		
		}
}
