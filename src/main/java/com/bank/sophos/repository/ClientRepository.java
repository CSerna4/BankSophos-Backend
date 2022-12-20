package com.bank.sophos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.sophos.entity.Clients;

public interface ClientRepository extends JpaRepository<Clients, Long>{

}
