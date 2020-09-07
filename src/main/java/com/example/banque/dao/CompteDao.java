package com.example.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banque.model.Compte;

@Repository
public interface CompteDao extends JpaRepository<Compte, String> {
   public Compte findByCodeCompte(String codeCompte);
}
