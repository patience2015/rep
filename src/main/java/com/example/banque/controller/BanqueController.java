package com.example.banque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.banque.model.Client;
import com.example.banque.model.Compte;
import com.example.banque.service.BanqueService;

// les données sont au format JSON par défaut
@RestController
public class BanqueController {

	@Autowired
	private BanqueService banqueService;
	
	@RequestMapping(value="banque/comptes/{codeCompte}", method=RequestMethod.GET)
	public Compte consulterCompte(@PathVariable String codeCompte) {
		
		return banqueService.consulterCompte(codeCompte);
	}
	
	//quand je charge un client, j'ai la liste de tous ces comptes 
	// dans chaque compte, j'ai la liste des opérations
	@RequestMapping(value="banque/clients/{codeClient}", method=RequestMethod.GET)
	public Client consulterClient(@PathVariable String codeClient) {
		
		return banqueService.consulterClient(codeClient);
	}
}
