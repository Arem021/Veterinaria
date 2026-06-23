package com.proyecto.veterinaria.controller;

import com.proyecto.veterinaria.dto.ApiResponse;
import com.proyecto.veterinaria.dto.CitaRequestDTO;
import com.proyecto.veterinaria.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.proyecto.veterinaria.util.UtilConstants.*;

@RestController
@RequestMapping("api/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService service;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> guardar(@RequestBody CitaRequestDTO request){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG14, service.guardar(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> listar(){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1, service.listar()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG1, service.buscarPorId(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> cancelar(@PathVariable Integer id){
        service.cancelar(id);
        return ResponseEntity.ok(new ApiResponse<>(true, MSG16, null));
    }
}
