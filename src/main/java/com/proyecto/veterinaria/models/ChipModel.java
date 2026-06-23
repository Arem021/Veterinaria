package com.proyecto.veterinaria.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "CHIP_RASTREOS")
@Data
public class ChipModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_chip")
    @SequenceGenerator(name = "seq_chip", sequenceName = "seq_chip", allocationSize = 1)
    @Column(name = "ID_CHIP")
    private Integer chip;

    @Column(name = "CODIGO_CHIP", unique = true)
    private Integer codigoChip;

    @Column(name = "FECHA_IMPLEMENTACION")
    private LocalDateTime fechaImplementacion;

    @Column(name = "FABRICANTE")
    private String fabricante;

    @OneToOne
    @JoinColumn(name = "ID_MASCOTA")
    private MascotasModel mascota;

    @Column(name = "ESTADO")
    private Integer estado = 1;
}
