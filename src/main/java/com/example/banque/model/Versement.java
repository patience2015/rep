package com.example.banque.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("VERSEMENT")
public class Versement extends Operation implements Serializable {

}
