package com.example.banque;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.banque.model.Client;
import com.example.banque.model.Compte;
import com.example.banque.model.CompteCourant;
import com.example.banque.model.CompteEpargne;
import com.example.banque.service.BanqueService;

@SpringBootApplication
public class BanqueApplication implements CommandLineRunner {

	@Autowired
	private BanqueService banqueService;
	
	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//on crée les clients 
		Client c1 = new Client("client1", "Alain");
		Client c2 = new Client("client2","Patience");
		
		banqueService.ajouterClient(c1);
		banqueService.ajouterClient(c2);
		
		//on créé les comptes, sachant qu'un compte appartient à un client
		// et un client peut avoir plusieurs comptes, un CC et un CE
		CompteCourant cp1 = new CompteCourant();
		cp1.setClient(c1);
		cp1.setCodeCompte("COMPTEC_1");
		cp1.setDateDeCreation(new Date());
		cp1.setSolde(new BigDecimal(1000.00));
		cp1.setDecouvert(new BigDecimal(0.00));
		
		CompteCourant cp2 = new CompteCourant();
		cp2.setClient(c2);
		cp2.setCodeCompte("COMPTEC_2");
		cp2.setDateDeCreation(new Date());
		cp2.setSolde(new BigDecimal(500.00));
		cp2.setDecouvert(new BigDecimal(0.00));
		
		CompteEpargne cp3 = new CompteEpargne();
		cp3.setClient(c1);
		cp3.setCodeCompte("COMPTEE_1");
		cp3.setDateDeCreation(new Date());
		cp3.setSolde(new BigDecimal(200000.00));
		cp3.setTaux(0.75);
	
		
		banqueService.ajouterCompte(cp1);
		banqueService.ajouterCompte(cp2);
		banqueService.ajouterCompte(cp3);
		
		//on effectue les opérations sur les comptes, versements et retraits
		banqueService.verser("COMPTEC_1", 33333.33);
		banqueService.verser("COMPTEC_2", 55555.55);
		banqueService.retirer("COMPTEE_1", 6666.00);
		banqueService.retirer("COMPTEC_1", 10000000.00); //solde insuffisant sur la console
		banqueService.virer("COMPTEE_1", "COMPTEC_1", 888.88);//virement du CE vers le CC
	}

}
