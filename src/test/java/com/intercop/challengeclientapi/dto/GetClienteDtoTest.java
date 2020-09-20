package com.intercop.challengeclientapi.dto;

import com.intercop.challengeclientapi.domain.Cliente;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class GetClienteDtoTest {
    @Test
    void when_tengo_cliente_then_return_dto() {
        ModelMapper modelMapper= new ModelMapper();
        Cliente cliente = new Cliente("Pepe", "Rios", 29, LocalDate.of(1990,12,26));
       cliente.setFechaProbableDeMuerte(LocalDate.now());
        GetClienteDto getClienteDto= GetClienteDto.getClientDtoFromEntity(modelMapper,cliente);
        assertThat(getClienteDto.getFechaProbableDeMuerte()).isNotNull();
        assertThat(getClienteDto.getFechaNacimiento()).isEqualTo("26/12/1990");
        assertThat(getClienteDto.getEdad()).isEqualTo(cliente.getEdad());
        assertThat(getClienteDto.getApellido()).isEqualTo(cliente.getApellido());
        assertThat(getClienteDto.getNombre()).isEqualTo(cliente.getNombre());


    }
}