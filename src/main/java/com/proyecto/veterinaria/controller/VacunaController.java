package com.proyecto.veterinaria.controller;


import com.proyecto.veterinaria.dto.ApiResponse;
import com.proyecto.veterinaria.dto.VacunaRequestDTO;
import com.proyecto.veterinaria.service.VacunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.proyecto.veterinaria.util.UtilConstants.*;

@RestController
@RequestMapping("api/vacunas")
@RequiredArgsConstructor
public class VacunaController {
    private final VacunaService service;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> guardar(@RequestBody VacunaRequestDTO request){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG11,service.guardar(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>>listar(){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1, service.listar()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return ResponseEntity.ok(new ApiResponse<>(true, MSG13, null));
    }
}
