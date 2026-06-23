package com.proyecto.veterinaria.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "VACUNAS")
@Data
public class VacunaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vacunas")
    @SequenceGenerator(name = "seq_vacunas", sequenceName = "seq_vacunas", allocationSize = 1)
    @Column(name = "ID_VACUNA")
    private Integer idVacuna;

    @Column(name = "NOMBRE_VACUNA")
    private String nombrevacuna;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA_APLICACION")
    private LocalDateTime fechaAplicacion;

    @Column(name = "PROXIMA_APLICACION")
    private LocalDateTime proximaAplicacion;

    @ManyToOne
    @JoinColumn(name = "ID_MASCOTA")
    private MascotasModel mascota;

    @Column(name = "ESTADO")
    private Integer estado = 1;
}
