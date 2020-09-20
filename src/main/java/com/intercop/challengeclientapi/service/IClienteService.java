package com.intercop.challengeclientapi.service;

import com.intercop.challengeclientapi.domain.Cliente;

import java.util.List;
import java.util.Map;

public interface IClienteService {
    List<Cliente> findAll();
    Cliente save(Cliente cliente);
    Map getKpi(List<Cliente> clientes);
    List<Cliente> calcularFechaProbableMuerteDeLosClientes(List<Cliente> clientes);
}
