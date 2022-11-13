package org.fstt.lsi.thymeleaf.web;

import java.util.List;

import org.fstt.lsi.thymeleaf.dao.SocieteRepository;
import org.fstt.lsi.thymeleaf.entities.Produit;
import org.fstt.lsi.thymeleaf.entities.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SocieteController {
	
	@Autowired
	private SocieteRepository societeRepository;

	    //affiches les societes
		@GetMapping(path="/societes")
		public String societes(Model model) {
			List<Societe> societes=societeRepository.findAll();
			model.addAttribute("listeSocietes",societes);
			return "societes";
		}
		
		//supprimer une societe
		@GetMapping(path = "/deleteSociete")
		private String delete(int id, String motCle, String page, String size) {

			societeRepository.deleteById(id);
			return "redirect:/societes?page=" + page + "&motCle=" + motCle + "&size=" + size;
		}
		
		//ajouter une societe
		@GetMapping(path = "/societe/new")
		private String createSocieteForm(Model model) {
			Societe societe=new Societe();
			model.addAttribute("societe",societe);
			return "create_societe";
		}
		
		@PostMapping(path="/societe/save")
		private String saveSociete(@ModelAttribute("societe")Societe s) {
			societeRepository.save(s);
			return "redirect:/societes";
		}
		
		//modifier une societe
		@GetMapping("/societes/edit/{id}")
		public String editSocieteForm(@PathVariable int id, Model model) {
			model.addAttribute("societe", societeRepository.findById(id).get());
			return "update_societe";
		}

		@PostMapping("/societes/{id}")
		public String updateSociete(@PathVariable int id,
				@ModelAttribute("societe") Societe societe,
				Model model) {
			
			Societe existingSociete = societeRepository.findById(id).get();
			existingSociete.setCode_ste(id);
			existingSociete.setFax_ste(societe.getFax_ste());
			existingSociete.setNom_ste(societe.getNom_ste());
			existingSociete.setTel_ste(societe.getTel_ste());
			

			societeRepository.save(existingSociete);
			return "redirect:/societes";		
		}
}
