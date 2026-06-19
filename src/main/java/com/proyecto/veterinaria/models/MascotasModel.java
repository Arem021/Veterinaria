package com.proyecto.veterinaria.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "MASCOTAS")
@Data
public class MascotasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mascotas")
    @SequenceGenerator(name = "seq_mascotas", sequenceName = "seq_name", allocationSize = 1)
    @Column(name = "ID_MASCOTA")
    private Integer idMascotas;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "ESPECIE")
    private String especie;

    @Column(name = "RAZA")
    private String raza;

    @Column(name = "EDAD")
    private Integer edad;

    @Column(name = "SEXO")
    private String sexo;

    @Column(name = "FECHA_INGRESO")
    private LocalDateTime fechaIngreso = LocalDateTime.now();

    @Column(name = "FECHA_ADOPCION")
    private LocalDateTime fechaAdopcion = LocalDateTime.now();

    @ManyToOne
    @JoinColumn (name = "ID_ADOPTANTE")
    private Integer idAdoptante = 1;

    @Column(name = "ESTADO")
    private Integer estado = 1 ;

}
