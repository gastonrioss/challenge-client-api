package com.intercop.challengeclientapi.controller;

import com.intercop.challengeclientapi.domain.Cliente;
import com.intercop.challengeclientapi.dto.*;
import com.intercop.challengeclientapi.service.IClienteService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {
    private IClienteService clienteService;
    private ModelMapper modelMapper;

    @Autowired
    public ClienteController(IClienteService clienteService, ModelMapper modelMapper) {
        this.clienteService = clienteService;
        this.modelMapper = modelMapper;
    }

    @ApiOperation(
            value = "Crea un cliente",
            response = SaveClienteDto.class
    )
    @PostMapping("creacliente")
    @ResponseBody
    public ResponseEntity<SaveClienteDto> create(@RequestBody @Valid final PostClienteDto postClienteDto) {
        return ResponseEntity.ok(SaveClienteDto.getClientDtoFromEntity(modelMapper,
                clienteService.save(PostClienteDto.getClientFromDto(modelMapper, postClienteDto))));
    }

    @ApiOperation(
            value = "Lista todos los clientes con su fecha probable de muerte",
            response = GetClienteDto.class
    )
    @GetMapping("listclientes")
    public ResponseEntity<List<GetClienteDto>> listclientes() {
        List<Cliente> clientes = clienteService.findAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(GetClienteDtoList.getClientDtoListFromEntityList(modelMapper,
                clienteService.calcularFechaProbableMuerteDeLosClientes(clientes)));
    }

    @ApiOperation(
            value = "promedio y desviacion estandar de las edades de los clientes",
            response = KpiDto.class
    )
    @GetMapping("kpideclientes")
    public ResponseEntity<KpiDto> kpideclientes() {
        List<Cliente> clientes = clienteService.findAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(modelMapper.map(clienteService.getKpi(clientes),KpiDto.class));
    }
}