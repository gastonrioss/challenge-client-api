package com.intercop.challengeclientapi.dto;

import com.intercop.challengeclientapi.domain.Cliente;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;


public class GetClienteDtoList {


    public static List<GetClienteDto> getClientDtoListFromEntityList(ModelMapper modelMapper,List<Cliente> clientes) {
        return clientes.stream().map(cliente -> GetClienteDto.getClientDtoFromEntity(modelMapper, cliente))
                .collect(Collectors.toList());
    }
}
