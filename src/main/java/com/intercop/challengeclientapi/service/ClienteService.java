package com.intercop.challengeclientapi.service;

import com.intercop.challengeclientapi.dao.IClienteDao;
import com.intercop.challengeclientapi.domain.Cliente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IClienteService {
    private final int mortalidad = 85;
    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }


    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public Map<String, Double> getKpi(List<Cliente> clientes) {
        Map<String, Double> kpi = new HashMap<>();
         List<Integer> edades = clientes.stream().mapToInt(Cliente::getEdad).boxed().collect(Collectors.toList());
        double average = getPromedioDeEdad(edades);
        kpi.put("promedio", getPromedioDeEdad(edades));
        kpi.put("desviacion", getDesviacionEstandar(average, edades));
        return kpi;
    }

    public double getDesviacionEstandar(double average, List<Integer> edades) {
        double standardDeviation = 0.0;
        for (int edad : edades) {
            standardDeviation += Math.pow(edad - average, 2);
        }

        return edades.isEmpty()?standardDeviation: Math.sqrt(standardDeviation / edades.size());
    }

    public double getPromedioDeEdad(List<Integer> edades) {
        double average = 0.0;
        return edades.stream().mapToInt(Integer::intValue).average().orElse(average);
    }

    @Override
    public List<Cliente> calcularFechaProbableMuerteDeLosClientes(List<Cliente> clientes) {
        clientes.stream().forEach(a -> a.setFechaProbableDeMuerte(calcularFechaDeMuerte(a.getFechaNacimiento())));
        return clientes;
    }

    public LocalDate calcularFechaDeMuerte(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        final int plus = Math.abs(mortalidad - Period.between(fechaNacimiento, fechaActual).getYears());
        return fechaActual.plusDays(plus).plusYears(plus);
    }
}
