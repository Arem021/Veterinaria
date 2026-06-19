package com.proyecto.veterinaria.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ADOPTANTES")
@Data
public class AdoptanteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_adoptantes")
    @SequenceGenerator(name = "seq_adoptantes", sequenceName = "seq_adoptantes", allocationSize = 1)

    @Column(name = "ID_ADOPTANTE")
    private Integer idAdoptante;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "ESTADO")
    private Integer estado =1;

    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fechaRegistro = LocalDateTime.now();
}
