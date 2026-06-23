package com.proyecto.veterinaria.dto;

import lombok.Data;

@Data
public class VacunaRequestDTO {
    private Integer idMascota;
    private String nombre;
    private String descripcion;
}
