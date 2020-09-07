package com.example.banque.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeOperation")
public abstract class Operation implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long numeroOperation;
    private Date dateOperation;
    private BigDecimal montant;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codeCompte")
    private Compte compte;
}
