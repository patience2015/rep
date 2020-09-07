package com.example.banque.service;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.banque.dao.ClientDao;
import com.example.banque.dao.CompteDao;
import com.example.banque.dao.OperationDao;
import com.example.banque.model.Client;
import com.example.banque.model.Compte;
import com.example.banque.model.CompteCourant;
import com.example.banque.model.Operation;
import com.example.banque.model.Versement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BanqueServiceImplTest {

	//on crée les mocks pour ne pas interagir avec la BDD
	@Mock
	private ClientDao clientDao;
	@Mock
	private CompteDao compteDao;
	@Mock
	private OperationDao operationDao;

	private BanqueServiceImpl banqueService;

	@Before
	public void setUp() throws Exception {
		banqueService = new BanqueServiceImpl();
		banqueService.setClientDao(clientDao);
		banqueService.setCompteDao(compteDao);
		banqueService.setOperationDao(operationDao);
	}

	@After
	public void tearDown() throws Exception {
		banqueService = null;
	}

	@Test
	public void ajouterClientTest() {
		Client c = getClient();
		when(clientDao.save(c)).thenReturn(c);
		Client ac = banqueService.ajouterClient(c);
		verify(clientDao).save(c);
		assertNotNull(ac);
		assertEquals(c, ac);
	}
	
	@Test
	public void ajouterCompteTest() {
		
	}
	
	@Test
	public void verserTest() {
		
	}
	
	@Test
	public void retirerTest() {
		
	}
	
	@Test
	public void virerTest() {
		
	}
	
	@Test
	public void consulterCompteTest() {
		
	}
	@Test
	public void consulterClientTest() {
		
	}
	@Test
	public void consulterOperationTest() {
		
	}

	private Client getClient() {
		Client c = new Client("CLIENT1", "POPOVICH");
		return c;
	}

	private Compte getCompte() {
		CompteCourant cc = new CompteCourant();
		cc.setClient(getClient());
		cc.setCodeCompte("CC1");
		cc.setDateDeCreation(new Date());
		cc.setDecouvert(new BigDecimal(000.00));
		cc.setSolde(new BigDecimal(222.00));
		return cc;
	}

	private Operation getOperation() {
		Versement v = new Versement();
		v.setCompte(getCompte());
		v.setDateOperation(new Date());
		v.setMontant(new BigDecimal(133.00));
		v.setNumeroOperation(1L);
		return v;
	}
}
