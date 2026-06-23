package com.proyecto.veterinaria.controller;

import com.proyecto.veterinaria.dto.ApiResponse;
import com.proyecto.veterinaria.dto.ChipRequestDTO;
import com.proyecto.veterinaria.service.ChipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.proyecto.veterinaria.util.UtilConstants.*;

@RestController
@RequestMapping("/api/chips")
@RequiredArgsConstructor
public class ChipController {
    private final ChipService service;

    @PostMapping
    public ResponseEntity<ApiResponse<?>>guardar(@RequestBody ChipRequestDTO request){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG8,service.guardar(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> listar(){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1, service.listar()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return ResponseEntity.ok(new ApiResponse<>(true,MSG10, null));
    }
}
