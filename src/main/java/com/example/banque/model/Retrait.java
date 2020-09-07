package com.example.banque.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
@Entity
@Data
@DiscriminatorValue("RETRAIT")
public class Retrait extends Operation implements Serializable {

}
