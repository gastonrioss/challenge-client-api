package com.intercop.challengeclientapi.dto;

import com.intercop.challengeclientapi.domain.Cliente;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class SaveClienteDtoTest {

    @Test
    void when_tengo_cliente_guardado_then_retorno_cliente_dto() {
        ModelMapper modelMapper= new ModelMapper();
        Cliente cliente = new Cliente("Pepe", "Rios", 29, LocalDate.of(1990,12,26));
        SaveClienteDto saveClienteDto= SaveClienteDto.getClientDtoFromEntity(modelMapper,cliente);
        assertThat(saveClienteDto.getFechaNacimiento()).isEqualTo("26/12/1990");
        assertThat(saveClienteDto.getEdad()).isEqualTo(cliente.getEdad());
        assertThat(saveClienteDto.getApellido()).isEqualTo(cliente.getApellido());
        assertThat(saveClienteDto.getNombre()).isEqualTo(cliente.getNombre());
    }
}