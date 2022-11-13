package org.fstt.lsi.thymeleaf.web;

import java.util.List;

import org.fstt.lsi.thymeleaf.dao.Ligne_cmdRepository;
import org.fstt.lsi.thymeleaf.entities.Ligne_cmd;
import org.fstt.lsi.thymeleaf.entities.Ligne_liv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ligne_cmdController {

	@Autowired
	private Ligne_cmdRepository ligne_cmdRepository;
	
	    //affiches les lignes de commande
		@GetMapping(path="/lignescmd")
		public String lignes(Model model) {
			List<Ligne_cmd> lignes_cmd=ligne_cmdRepository.findAll();
			model.addAttribute("lignescmd",lignes_cmd);
			return "lignescmd";
		}
		
		//supprimer une ligne de commande
		@GetMapping(path = "/deleteLignecmd")
			private String delete(int id, String motCle, String page, String size) {
			ligne_cmdRepository.deleteById(id);
			return "redirect:/lignescmd?page=" + page + "&motCle=" + motCle + "&size=" + size;
		}
		@GetMapping("/lignescmd/new")
		public String createLignescmdForm(Model model) {
			
			// create student object to hold student form data
			Ligne_cmd lignescmd = new Ligne_cmd();
			model.addAttribute("lignescmd", lignescmd);
			return "create_lignescmd";
			
		}
		@PostMapping(path="/lignescmd/save") 
		private String savelignescmd(@ModelAttribute("lignescmd") Ligne_cmd l) { 
			ligne_cmdRepository.save(l);
	      return "redirect:/lignescmd";
		 }
		@GetMapping("/lignescmd/edit/{id}")
		public String editlignescmdForm(@PathVariable int id, Model model) {
			model.addAttribute("lignescmd", ligne_cmdRepository.findById(id).get());
			return "update_lignescmd";
		}

		@PostMapping("/lignescmd/{id}")
		public String updatelignesliv(@PathVariable int id,
				@ModelAttribute("lignescmd") Ligne_cmd lignescmd,
				Model model) {
			// get student from database by id
			Ligne_cmd existingcmd = ligne_cmdRepository.findById(id).get();
			existingcmd.setNum_ligne(id);
			existingcmd.setQte_cmd(lignescmd.getQte_cmd());
			existingcmd.setArticle(lignescmd.getArticle());
			existingcmd.setCommande(lignescmd.getCommande());


			
			// save updated student object
			ligne_cmdRepository.save(existingcmd);
			return "redirect:/lignescmd";		
		}
		
}