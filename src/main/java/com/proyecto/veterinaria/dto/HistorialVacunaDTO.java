package com.proyecto.veterinaria.dto;

import lombok.Data;

import java.util.List;

@Data
public class HistorialVacunaDTO {
    private Integer idMascota;
    private String nombre;
    private List<VacunaResponseDTO>vacunas;
}
