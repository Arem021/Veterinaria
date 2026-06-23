package com.proyecto.veterinaria.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CitaResponseDTO {
    private Integer idCita;
    private LocalDateTime fecha;
    private String motivo;
    private String estatus;
}
