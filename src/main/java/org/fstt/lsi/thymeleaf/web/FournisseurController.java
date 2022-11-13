package org.fstt.lsi.thymeleaf.web;

import java.util.List;

import org.fstt.lsi.thymeleaf.dao.FournisseurRepository;
import org.fstt.lsi.thymeleaf.entities.Fournisseur;
import org.fstt.lsi.thymeleaf.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FournisseurController {

	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	    //affiches les commandes
		@GetMapping(path="/fournisseurs")
		public String fournisseurs(Model model) {
			List<Fournisseur> fournisseurs=fournisseurRepository.findAll();
			model.addAttribute("listeFournisseurs",fournisseurs);
			return "fournisseurs";
		}
		
		//supprimer une ligne de commande
		@GetMapping(path = "/deleteFournisseur")
			private String delete(int id, String motCle, String page, String size) {
			fournisseurRepository.deleteById(id);
			return "redirect:/fournisseurs?page=" + page + "&motCle=" + motCle + "&size=" + size;
		}
		@GetMapping("/fournisseur/new")
		public String createfournisseurForm(Model model) {
			
			// create student object to hold student form data
			Fournisseur fournisseur = new Fournisseur();
			model.addAttribute("fournisseur", fournisseur);
			return "create_fournisseur";
			
		}
		@PostMapping(path="/fournisseur/save") 
		private String saveFournisseur(@ModelAttribute("fournisseur") Fournisseur c) { 
			fournisseurRepository.save(c);
	      return "redirect:/fournisseurs";
		 }
		@GetMapping("/fournisseurs/edit/{id}")
		public String editFournisseurForm(@PathVariable int id, Model model) {
			model.addAttribute("fournisseur", fournisseurRepository.findById(id).get());
			return "update_fournisseur";
		}

		@PostMapping("/fournisseurs/{id}")
		public String updateFournisseur(@PathVariable int id,
				@ModelAttribute("fournisseur") Fournisseur fournisseur,
				Model model) {
			
			// get student from database by id
			Fournisseur Existingfournisseur = fournisseurRepository.findById(id).get();
			Existingfournisseur.setCode_four(id);
			Existingfournisseur.setNom_four(fournisseur.getNom_four());
			Existingfournisseur.setVille_four(fournisseur.getVille_four());
			Existingfournisseur.setTel_four(fournisseur.getTel_four());
			

			// save updated student object
			fournisseurRepository.save(Existingfournisseur);
			return "redirect:/fournisseurs";	
			
			

	
		}
}