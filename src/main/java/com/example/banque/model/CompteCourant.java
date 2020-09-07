package com.example.banque.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("COMPTE COURANT")
public class CompteCourant extends Compte implements Serializable {

	private BigDecimal decouvert;

}
