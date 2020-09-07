package com.example.banque.model;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Client implements Serializable{

	@Id
	private String codeClient;
	private String nom;
	@OneToMany(mappedBy="client")
	private List<Compte> comptes;
	public Client() {
		
	}
	public Client(String codeClient, String nom) {
		super();
		this.codeClient = codeClient;
		this.nom = nom;
	}
	
}
