package com.proyecto.veterinaria.dto;

import lombok.Data;

@Data
public class MascotaRequestDTO {
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private String sexo;
    private Integer idAdoptante;
}
