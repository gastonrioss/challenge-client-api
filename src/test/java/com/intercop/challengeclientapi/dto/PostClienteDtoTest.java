package com.intercop.challengeclientapi.dto;

import com.intercop.challengeclientapi.domain.Cliente;
import com.intercop.challengeclientapi.util.HelperDate;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;

class PostClienteDtoTest {

    @Test
    void when_quiero_guardar_cliente_dto_then_retorno_entity_cliente() {
        ModelMapper modelMapper= new ModelMapper();
        PostClienteDto postClienteDto = new PostClienteDto("Pepe", "Rios", 29, "26/12/1990");
        Cliente cliente= PostClienteDto.getClientFromDto(modelMapper,postClienteDto);
        assertThat(cliente.getFechaNacimiento()).isEqualTo(HelperDate.toDate(postClienteDto.getFechaNacimiento()));
        assertThat(cliente.getEdad()).isEqualTo(cliente.getEdad());
        assertThat(cliente.getApellido()).isEqualTo(cliente.getApellido());
        assertThat(cliente.getNombre()).isEqualTo(cliente.getNombre());
    }

}