package com.proyecto.veterinaria.dto;

import lombok.Data;

@Data
public class ChipRequestDTO {
    private Integer idMascota;
    private Integer codigoChip;
    private String fabricante;
}
