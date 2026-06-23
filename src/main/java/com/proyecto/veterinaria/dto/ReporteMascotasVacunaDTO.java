package com.proyecto.veterinaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteMascotasVacunaDTO {
    private Integer idMascota;
    private String nombre;
    private String especie;
    private Long totalVacunas;
}
