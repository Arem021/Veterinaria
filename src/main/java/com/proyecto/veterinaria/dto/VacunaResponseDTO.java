package com.proyecto.veterinaria.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VacunaResponseDTO {
    private Integer idVacuna;
    private String nombre;
    private LocalDateTime fechaAplicacion;
    private LocalDateTime proximaAplicacion;
}
