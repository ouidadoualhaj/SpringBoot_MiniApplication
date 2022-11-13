package org.fstt.lsi.thymeleaf.web;
  
import java.util.List; 
import org.fstt.lsi.thymeleaf.dao.ProduitRepository;
import org.fstt.lsi.thymeleaf.entities.Produit;
import org.fstt.lsi.thymeleaf.entities.Produit; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 

@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;

	

	//affiches les livraisons
	@GetMapping(path="/products")
	public String products(Model model) {
			List<Produit> products=produitRepository.findAll();
			model.addAttribute("listeProducts",products);
			return "products";
	}
	
	//supprimer un article
	@GetMapping(path = "/deleteArticle")
	private String delete(int id, String motCle, String page, String size) {
		    produitRepository.deleteById(id);
			return "redirect:/products?page=" + page + "&motCle=" + motCle + "&size=" + size;
	}
	@GetMapping("/produit/new")
	public String createProduitForm(Model model) {
		
		Produit produit = new Produit();
		model.addAttribute("produit", produit);
		return "create_produit";
		
	}
	@PostMapping(path="/produit/save") 
	private String saveProduit(@ModelAttribute("produit") Produit c) { 
		produitRepository.save(c);
      return "redirect:/products";
	 }
	@GetMapping("/produits/edit/{id}")
	public String editProduitForm(@PathVariable int id, Model model) {
		model.addAttribute("produit", produitRepository.findById(id).get());
		return "update_produit";
	}

	@PostMapping("/produits/{id}")
	public String updateProduit(@PathVariable int id,
			@ModelAttribute("produit") Produit produit,
			Model model) {
		
		// get student from database by id
		Produit existingProduit = produitRepository.findById(id).get();
		existingProduit.setCode_art(id);
		existingProduit.setNom_art(produit.getNom_art());
		existingProduit.setPu(produit.getPu());
		existingProduit.setQte_stock(produit.getQte_stock());
		

		// save updated student object
		produitRepository.save(existingProduit);
		return "redirect:/products";		
	}
	
	
}