package com.example.banque.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeDeCompte")
public abstract class Compte implements Serializable {

	@Id
	private String codeCompte;
	private BigDecimal solde;
	private Date dateDeCreation;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="codeClient")
	private Client client;
	@OneToMany(mappedBy="compte")
	private List<Operation> operations;
		
}
