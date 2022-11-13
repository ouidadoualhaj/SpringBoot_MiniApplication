  package org.fstt.lsi.thymeleaf.web; 

import java.util.List;

import org.fstt.lsi.thymeleaf.dao.ClientRepository;
import org.fstt.lsi.thymeleaf.entities.Client;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	//afficher tous les clients
	@GetMapping(path="/clients")
	public String clients(Model model) {
		List<Client> clients=clientRepository.findAll();
		model.addAttribute("listeClients",clients);
		return "clients";
	}

	//supprimer un client
	@GetMapping(path = "/deleteClient")
	private String delete(int id, String motCle, String page, String size) {
		    clientRepository.deleteById(id);
			return "redirect:/clients?page=" + page + "&motCle=" + motCle + "&size=" + size;
	}
	
	//ajouter un client
	@GetMapping(path = "/client/new")
	private String createClientForm(Model model) {
		Client client=new Client();
		model.addAttribute("client",client);
		return "create_client";
	}
	
	@PostMapping(path="/client/save")
	private String saveClient(@ModelAttribute("client")Client c) {
		clientRepository.save(c);
		return "redirect:/clients";
	}
	
	@GetMapping("/clients/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("client", clientRepository.findById(id).get());
		return "update_client";
	}

	@PostMapping("/clients/{id}")
	public String updateClient(@PathVariable int id,
			@ModelAttribute("client") Client client,
			Model model) {
		
		// get student from database by id
		Client existingClient = clientRepository.findById(id).get();
		existingClient.setCode_cli(id);
		existingClient.setNom_cli(client.getNom_cli());
		existingClient.setPre_cli(client.getPre_cli());
		existingClient.setAdr_cli(client.getAdr_cli());
		existingClient.setTel_cli(client.getTel_cli());
		existingClient.setVille_cli(client.getVille_cli());

		// save updated student object
		clientRepository.save(existingClient);
		return "redirect:/clients";		
	}


}