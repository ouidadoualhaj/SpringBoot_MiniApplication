package org.fstt.lsi.thymeleaf.dao;

import org.fstt.lsi.thymeleaf.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Integer>{

}
