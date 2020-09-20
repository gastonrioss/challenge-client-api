package com.intercop.challengeclientapi.dao;

import com.intercop.challengeclientapi.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
}
