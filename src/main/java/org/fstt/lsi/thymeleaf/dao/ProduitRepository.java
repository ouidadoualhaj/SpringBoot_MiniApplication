package org.fstt.lsi.thymeleaf.dao;


import org.fstt.lsi.thymeleaf.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProduitRepository extends JpaRepository<Produit, Integer> {

	
}
