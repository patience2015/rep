package com.example.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banque.model.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, String> {
       public Client findByCodeClient(String codeClient); 
}
