package com.example.banque.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.banque.dao.ClientDao;
import com.example.banque.dao.CompteDao;
import com.example.banque.dao.OperationDao;
import com.example.banque.model.Client;
import com.example.banque.model.Compte;
import com.example.banque.model.Operation;
import com.example.banque.model.Retrait;
import com.example.banque.model.Versement;

import lombok.Data;

@Data
@Service
@Transactional
public class BanqueServiceImpl implements BanqueService {
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private CompteDao compteDao;
	@Autowired
	private OperationDao operationDao;

	@Override
	public void verser(String codeCompte, double montant) {
		// TODO Auto-generated method stub
		long leftLimit = 1L;
	    long rightLimit = 10L;
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	    
		Compte c = compteDao.findByCodeCompte(codeCompte);
		if(c == null) {
			System.out.println("compte non trouvable");
			return;
		}
		
		//création de l'opération
		Versement v = new Versement();
		v.setCompte(c);
		v.setMontant(new BigDecimal(montant));
		v.setDateOperation(new Date());
		v.setNumeroOperation(generatedLong);
		operationDao.save(v);
		//mise à jour solde compte
		c.setSolde(c.getSolde().add(v.getMontant()));
		compteDao.save(c);
	}

	@Override
	public void retirer(String codeCompte, double montant) {
		// TODO Auto-generated method stub
		long leftLimit = 1L;
	    long rightLimit = 10L;
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	    
		Compte c = compteDao.findByCodeCompte(codeCompte);
		if(c == null) {
			System.out.println("compte non trouvable");
			return;
		}
		
		//on vérifie le solde avant d'effectuer le retrait
		if(c.getSolde().compareTo(new BigDecimal(montant)) <0) {
			System.out.println("solde insuffisant");
			return;
		}
		//création de l'opération
		Retrait r = new Retrait();
		r.setCompte(c);
		r.setMontant(new BigDecimal(montant).negate());
		r.setDateOperation(new Date());
		r.setNumeroOperation(generatedLong);
		operationDao.save(r);
		//mise à jour solde compte
		c.setSolde(c.getSolde().add(new BigDecimal(montant).negate()));
		compteDao.save(c);
	}

	@Override
	public List<Operation> consulterOperation(String codeCompte) {
		// TODO Auto-generated method stub
		Compte c = compteDao.findByCodeCompte(codeCompte);
		if(c == null) {
			System.out.println("compte non trouvable");
			return null;
		}
		return c.getOperations();
	}

	@Override
	public Client ajouterClient(Client client) {
		// TODO Auto-generated method stub
		return clientDao.save(client);
	}

	@Override
	public Compte ajouterCompte(Compte compte) {
		// TODO Auto-generated method stub
		return compteDao.save(compte);
	}

	@Override
	public Compte consulterCompte(String codeCompte) {
		// TODO Auto-generated method stub
		Compte c = compteDao.findByCodeCompte(codeCompte);
		if(c == null) {
			System.out.println("compte non trouvable");
			return null;
		}
		return c;
	}

	@Override
	public Client consulterClient(String codeClient) {
		// TODO Auto-generated method stub
		Client c = clientDao.findByCodeClient(codeClient);
		if(c == null ) {
			System.out.println("client introuvable");
			return null;
		}
		return c;
	}

	//le virement consiste au retrait d'un compte1 et d'un versement dans un compte2
	//du même montant
	@Override
	public void virer(String codeCompte1, String codeCompte2, double montant) {
		// TODO Auto-generated method stub
		retirer(codeCompte1, montant);
		verser(codeCompte2, montant);
	}

}
