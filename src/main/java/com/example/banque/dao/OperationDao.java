package com.example.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banque.model.Operation;

@Repository
public interface OperationDao extends JpaRepository<Operation, Long> {
   public Operation findByNumeroOperation(long numeroOperation);
}
