package com.intercop.challengeclientapi.dto;

import com.intercop.challengeclientapi.domain.Cliente;
import com.intercop.challengeclientapi.util.HelperDate;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class PostClienteDto {

    @Size(max = 30)
    @NotBlank
    @NotNull
    private String nombre;

    @Size(max = 30)
    @NotBlank
    @NotNull
    private String apellido;

    @NotNull
    private int edad;

    @NotBlank
    @NotNull
    private String fechaNacimiento;

    public PostClienteDto(@Size(max = 30) @NotBlank @NotNull String nombre, @Size(max = 30) @NotBlank @NotNull String apellido, @NotNull int edad, @NotBlank @NotNull String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public static Cliente getClientFromDto(ModelMapper modelMapper, PostClienteDto postClienteDto) {
        Cliente cliente = modelMapper.map(postClienteDto, Cliente.class);
        cliente.setFechaNacimiento(HelperDate.toDate(postClienteDto.getFechaNacimiento()));
        return  cliente;
    }






}
