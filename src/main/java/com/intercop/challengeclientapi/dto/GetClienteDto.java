package com.intercop.challengeclientapi.dto;

import com.intercop.challengeclientapi.domain.Cliente;
import com.intercop.challengeclientapi.util.HelperDate;
import lombok.Data;
import org.modelmapper.ModelMapper;


@Data
public class GetClienteDto {
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private String fechaNacimiento;
    private String fechaProbableDeMuerte;

    public static GetClienteDto getClientDtoFromEntity(ModelMapper modelMapper, Cliente cliente) {
        GetClienteDto getClienteDto= modelMapper.map(cliente, GetClienteDto.class);
        getClienteDto.setFechaNacimiento(HelperDate.toString(cliente.getFechaNacimiento()));
        getClienteDto.setFechaProbableDeMuerte(HelperDate.toString(cliente.getFechaProbableDeMuerte()));
        return  getClienteDto;
    }
}
