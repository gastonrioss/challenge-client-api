package com.intercop.challengeclientapi.dto;

import com.intercop.challengeclientapi.domain.Cliente;
import com.intercop.challengeclientapi.util.HelperDate;
import lombok.Data;
import org.modelmapper.ModelMapper;


@Data
public class SaveClienteDto {

    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private String fechaNacimiento;

    public static SaveClienteDto getClientDtoFromEntity(ModelMapper modelMapper, Cliente cliente) {
        SaveClienteDto saveClienteDto = modelMapper.map(cliente, SaveClienteDto.class);
        saveClienteDto.setFechaNacimiento(HelperDate.toString(cliente.getFechaNacimiento()));
        return  saveClienteDto;
    }






}
