package com.proyecto.veterinaria.controller;

import com.proyecto.veterinaria.dto.ApiResponse;
import com.proyecto.veterinaria.models.AdoptanteModel;
import com.proyecto.veterinaria.service.AdoptanteService;
import com.proyecto.veterinaria.service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.proyecto.veterinaria.util.UtilConstants.*;

@RestController
@RequestMapping("api/adoptantes")
@RequiredArgsConstructor
public class AdoptanteController {
    private final AdoptanteService service;
    private final MascotaService mascotaService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> guardar(@RequestBody AdoptanteModel adoptante){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG2, service.guardar(adoptante)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> listar(){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1, service.listar()));
    }

    @GetMapping("/{id}/mascotas")
    public ResponseEntity<ApiResponse<?>> buscarmascotaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(new ApiResponse<>(true,MSG1, mascotaService.listarMascotasPorAdoptante(id)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG1, service.buscarPorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> actualizar(@PathVariable Integer id, @RequestBody AdoptanteModel adoptante){
        return ResponseEntity.ok(new ApiResponse<>(true, MSG3, service.actualizar(id, adoptante)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return ResponseEntity.ok(new ApiResponse<>(true, MSG4, null));
    }
}
