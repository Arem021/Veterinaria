package com.proyecto.veterinaria.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MascotaResponseDTO {
    private Integer idMascota;
    private String nombre;
    private String especie;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaAdopcion;
    private Integer idAdoptante;
    private String nombreAdoptante;
}
