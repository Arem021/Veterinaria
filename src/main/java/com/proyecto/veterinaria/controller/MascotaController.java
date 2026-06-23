package com.proyecto.veterinaria.controller;

import com.proyecto.veterinaria.dto.ApiResponse;
import com.proyecto.veterinaria.dto.MascotaRequestDTO;
import com.proyecto.veterinaria.service.MascotaService;
import com.proyecto.veterinaria.service.VacunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.proyecto.veterinaria.util.UtilConstants.*;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaController {
    private final MascotaService service;
    private final VacunaService vacunaService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> guardar(@RequestBody MascotaRequestDTO request){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG5, service.guardar(request)));
    }
    @GetMapping
    public ResponseEntity<ApiResponse<?>> listar(){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1,service.listar()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1, service.buscarPorId(id)));
    }

    @GetMapping("/{id}/vacunas")
    public ResponseEntity<ApiResponse<?>> historialVacunas(@PathVariable Integer id){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1, vacunaService.historialVacuna(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> actualizar(@PathVariable Integer id, @RequestBody MascotaRequestDTO request){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG6, service.actualizar(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return ResponseEntity.ok(new ApiResponse<>(true, MSG7, null));
    }

}
