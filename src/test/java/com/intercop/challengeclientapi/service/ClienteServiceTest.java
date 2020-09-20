package com.intercop.challengeclientapi.service;

import com.intercop.challengeclientapi.dao.IClienteDao;
import com.intercop.challengeclientapi.domain.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;
    @Mock
    private IClienteDao clienteDao;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void when_guardar_cliente__then_retorna_cliente_guardado() {
        Cliente cliente = new Cliente("Pepe", "Rios", 29,LocalDate.of(1990,12,26));
        when(clienteDao.save(any(Cliente.class))).thenReturn(cliente);
        Cliente clienteGuardado = clienteService.save(cliente);
        assertThat(clienteGuardado).isNotNull();
        assertThat(clienteGuardado.getNombre()).isEqualTo(cliente.getNombre());
        assertThat(clienteGuardado.getApellido()).isEqualTo(cliente.getApellido());
        assertThat(clienteGuardado.getEdad()).isEqualTo(cliente.getEdad());
    }

    @Test
    void when_busca_todos_los_clientes__then_retorna_todos_los_clientes_guardados() {
        Cliente c1 = new Cliente("Pepe", "Rios", 29,LocalDate.of(1990,12,26));
        Cliente c2 = new Cliente("Martin", "test", 28,LocalDate.of(1991,12,26));
        List<Cliente> clienteList = Arrays.asList(c1, c2);
        when(clienteDao.findAll()).thenReturn(clienteList);
        List<Cliente> clientesGuardados = clienteService.findAll();
        assertThat(clientesGuardados).isNotNull();
        assertThat(clientesGuardados.size()).isEqualTo(2);
    }
    @Test
    void when_calcula_fecha_muerte_clients__then_retorna_todos_los_clientes_con_fecha_muerte() {
        Cliente c1 = new Cliente("Pepe", "Rios", 29,LocalDate.of(1990,12,26));
        Cliente c2 = new Cliente("Martin", "test", 28,LocalDate.of(1991,12,26));
        List<Cliente> clienteList = Arrays.asList(c1, c2);
        List<Cliente> clientesConFechaMuerte = clienteService.calcularFechaProbableMuerteDeLosClientes(clienteList);
        assertThat(clientesConFechaMuerte).isNotNull();
        assertThat(clientesConFechaMuerte.get(0).getFechaProbableDeMuerte()).isNotNull();
    }
    @Test
    void when_calcula_fecha_muerte__then_retorna_fecha_mayor_a_nacimiento() {
       LocalDate fechaNacimiento= LocalDate.now();
       LocalDate fechaMuerte= clienteService.calcularFechaDeMuerte(fechaNacimiento);
        assertThat(fechaMuerte).isNotNull();
        assertThat(fechaMuerte).isAfter(fechaNacimiento);
    }
    @Test
    void when_tengo_clientes_con_edad_20_30__then_retorna_promedio_25() {
        double promedioEsperado=25.0;
        double promedio= clienteService.getPromedioDeEdad(Arrays.asList(20,30));
        assertThat(promedio).isNotNull();
        assertThat(promedio).isEqualTo(promedioEsperado);
    }
    @Test
    void when_no_hay_edades__then_retorna_promedio_0() {
        double promedioEsperado=0.0;
        double promedio= clienteService.getPromedioDeEdad(Collections.emptyList());
        assertThat(promedio).isEqualTo(promedioEsperado);
    }
    @Test
    void when_no_hay_clientes_then_kpi_0() {
        double promedioEsperado =0.0;
        double desviacionEsperada=0.0;

        Map<String,Double> kpi= clienteService.getKpi(Collections.emptyList());
        assertThat(kpi.get("promedio")).isEqualTo(promedioEsperado);
        assertThat(kpi.get("desviacion")).isEqualTo(desviacionEsperada);
    }

}