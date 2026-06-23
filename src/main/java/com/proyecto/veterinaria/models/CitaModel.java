package com.proyecto.veterinaria.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "CITAS")
@Data
public class CitaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_citas")
    @SequenceGenerator(name = "seq_citas", sequenceName = "seq_citas", allocationSize = 1)
    @Column(name = "ID_CITA")
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "ID_MASCOTA")
    private MascotasModel idMascota;

    @Column(name = "FECHA_CITA")
    private LocalDateTime fechaCita;

    @Column(name = "MOTIVO")
    private String motivo;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @Column(name = "ESTATUS")
    private String estatus;

    @Column(name = "ESTADO")
    private Integer estado = 1;

}
