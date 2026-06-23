package com.proyecto.veterinaria.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CitaRequestDTO {
    private Integer idMascota;
    private LocalDateTime fechaCita;
    private String motivo;
    private String observaciones;
}
