package com.example.banque.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.banque.model.Client;
import com.example.banque.model.Compte;
import com.example.banque.model.Operation;

public interface BanqueService {

	public Client ajouterClient(Client client);
	public Compte ajouterCompte(Compte compte);
	public void verser(String codeCompte, double montant);
	public void retirer(String codeCompte, double montant);
	public List<Operation> consulterOperation(String codeCompte);
	public Compte consulterCompte(String codeCompte);
	public Client consulterClient(String codeClient);
	public void virer(String codeCompte1,String codeCompte2, double montant);
}
