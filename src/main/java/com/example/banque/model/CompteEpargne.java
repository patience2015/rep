package com.example.banque.model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("COMPTE EPARGNE")
public class CompteEpargne extends Compte implements Serializable{

	private double taux;
}
