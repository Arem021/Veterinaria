package com.proyecto.veterinaria.controller;

import com.proyecto.veterinaria.dto.ApiResponse;
import com.proyecto.veterinaria.service.VacunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.proyecto.veterinaria.util.UtilConstants.*;

@RestController
@RequestMapping("api/reportes")
@RequiredArgsConstructor
public class ReporteController {
    private final VacunaService vacunaService;

    @GetMapping("/mascotas-vacunadas")
    public ResponseEntity<ApiResponse<?>> mascotasVacunadas(){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1, vacunaService.reporteMascotasVacunadas()));
    }
}
