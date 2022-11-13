package org.fstt.lsi.thymeleaf.dao;

import org.fstt.lsi.thymeleaf.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;


public interface  ClientRepository extends JpaRepository<Client,Integer>{
	
	
}
