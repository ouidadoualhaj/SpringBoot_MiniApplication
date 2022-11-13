package org.fstt.lsi.thymeleaf.web;

import java.util.List;

import org.fstt.lsi.thymeleaf.dao.Ligne_livRepository;
import org.fstt.lsi.thymeleaf.entities.Client;
import org.fstt.lsi.thymeleaf.entities.Ligne_liv;
import org.fstt.lsi.thymeleaf.entities.Livraison;
import org.fstt.lsi.thymeleaf.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ligne_livController {

	@Autowired
	private Ligne_livRepository ligne_livRepository;
	
	//affiches les lignes de livraison
	@GetMapping(path="/lignesliv")
	public String lignes(Model model) {
		List<Ligne_liv> lignes_liv=ligne_livRepository.findAll();
		model.addAttribute("lignesliv",lignes_liv);
		return "lignesliv";
	}
	
	//supprimer une ligne de livraison
	@GetMapping(path = "/deleteLigneliv")
		private String delete(int id, String motCle, String page, String size) {
		ligne_livRepository.deleteById(id);
		return "redirect:/lignesliv?page=" + page + "&motCle=" + motCle + "&size=" + size;
	}
	@GetMapping("/lignesliv/new")
	public String createLigneslivForm(Model model) {
		
		// create student object to hold student form data
		Ligne_liv lignesliv = new Ligne_liv();
		model.addAttribute("lignesliv", lignesliv);
		return "create_lignesliv";
		
	}
	@PostMapping(path="/lignesliv/save") 
	private String savelignesliv(@ModelAttribute("lignesliv") Ligne_liv l) { 
		ligne_livRepository.save(l);
      return "redirect:/lignesliv";
	 }
	@GetMapping("/lignesliv/edit/{id}")
	public String editligneslivForm(@PathVariable int id, Model model) {
		model.addAttribute("lignesliv", ligne_livRepository.findById(id).get());
		return "update_lignesliv";
	}

	@PostMapping("/lignesliv/{id}")
	public String updatelignesliv(@PathVariable int id,
			@ModelAttribute("lignesliv") Ligne_liv lignesliv,
			Model model) {
		// get student from database by id
		Ligne_liv Existinglignesliv = ligne_livRepository.findById(id).get();
		Existinglignesliv.setNum_ligne(id);
		Existinglignesliv.setQte_liv(lignesliv.getQte_liv());
		Existinglignesliv.setArticle(lignesliv.getArticle());
		Existinglignesliv.setLivraison(lignesliv.getLivraison());


		
		// save updated student object
		ligne_livRepository.save(Existinglignesliv);
		return "redirect:/lignesliv";		
	}
	
}