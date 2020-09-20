package com.intercop.challengeclientapi.dto;

import com.intercop.challengeclientapi.domain.Cliente;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GetClienteDtoListTest {

    @Test
    void when_tenemos_lista_clientes_retorna_lista_dto() {
        ModelMapper modelMapper= new ModelMapper();
        Cliente cliente = new Cliente("Pepe", "Rios", 29, LocalDate.of(1990,12,26));
        cliente.setFechaProbableDeMuerte(LocalDate.now());
        List<GetClienteDto> getClienteDtoList= GetClienteDtoList.getClientDtoListFromEntityList(modelMapper, Arrays.asList(cliente));
        assertThat(getClienteDtoList).isNotNull();
        assertThat(getClienteDtoList.size()).isEqualTo(1);
    }
}