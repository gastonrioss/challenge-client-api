package com.intercop.challengeclientapi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Data
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private LocalDate fechaNacimiento;

    private LocalDate fechaProbableDeMuerte;


    public Cliente(final String nombre, final String apellido, final Integer edad, final LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }
}
