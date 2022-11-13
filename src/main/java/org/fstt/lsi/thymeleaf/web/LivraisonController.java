package org.fstt.lsi.thymeleaf.web;

import java.util.List;

import org.fstt.lsi.thymeleaf.dao.LivraisonRepository;
import org.fstt.lsi.thymeleaf.entities.Livraison;
import org.fstt.lsi.thymeleaf.entities.Commande;
import org.fstt.lsi.thymeleaf.entities.Fournisseur;
import org.fstt.lsi.thymeleaf.entities.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivraisonController {

	@Autowired
	private LivraisonRepository livraisonRepository;

	   //affiches les livraisons
		@GetMapping(path="/livraisons")
		public String livraisons(Model model) {
			List<Livraison> livraisons=livraisonRepository.findAll();
			model.addAttribute("listeLivraisons",livraisons);
			return "livraisons";
		}
		
		//supprimer une societe
		@GetMapping(path = "/deleteLivraison")
			private String delete(int id, String motCle, String page, String size) {
			livraisonRepository.deleteById(id);
			return "redirect:/livraisons?page=" + page + "&motCle=" + motCle + "&size=" + size;
		}
		@GetMapping("/livraison/new")
		public String createLivraisonForm(Model model) {
			
			// create student object to hold student form data
			Livraison livraison = new Livraison();
			model.addAttribute("livraison", livraison);
			return "create_livraison";
			
		}
		@PostMapping(path="/livraison/save") 
		private String saveLivraison(@ModelAttribute("livraison") Livraison c) { 
			livraisonRepository.save(c);
	      return "redirect:/livraisons";
		 }
		
		@GetMapping("/livraisons/edit/{id}")
		public String editlivraisonForm(@PathVariable int id, Model model) {
			model.addAttribute("livraison", livraisonRepository.findById(id).get());
			return "update_livraison";
		}

		@PostMapping("/livraisons/{id}")
		public String updatelivraison(@PathVariable int id,
				@ModelAttribute("livraison") Livraison livraison,
				Model model) {
			
			// get student from database by id
			Livraison Existinglivraison = livraisonRepository.findById(id).get();
			Existinglivraison.setNum_liv(id);
			Existinglivraison.setDate_liv(livraison.getDate_liv());
			Existinglivraison.setFournisseur(livraison.getFournisseur());
			
			// save updated student object
			livraisonRepository.save(Existinglivraison);
			return "redirect:/livraisons";		
		}
		
}