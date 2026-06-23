package com.proyecto.veterinaria.service;

import com.proyecto.veterinaria.dto.HistorialVacunaDTO;
import com.proyecto.veterinaria.dto.ReporteMascotasVacunaDTO;
import com.proyecto.veterinaria.dto.VacunaRequestDTO;
import com.proyecto.veterinaria.dto.VacunaResponseDTO;
import com.proyecto.veterinaria.models.MascotasModel;
import com.proyecto.veterinaria.models.VacunaModel;
import com.proyecto.veterinaria.repository.MascotasRepository;
import com.proyecto.veterinaria.repository.VacunasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.proyecto.veterinaria.util.UtilConstants.*;

@Service
@AllArgsConstructor
public class VacunaService {
    private final VacunasRepository repository;
    private final MascotasRepository mascotasRepository;

    public VacunaModel guardar(VacunaRequestDTO request){
        MascotasModel mascota = mascotasRepository.findById(request.getIdMascota())
                .orElseThrow(()-> new RuntimeException(MSG18));
        if (mascota.getEstado().equals(CODENEG)){
            throw new RuntimeException(MSG23);
        }
        VacunaModel vacuna = new VacunaModel();
        vacuna.setNombrevacuna(request.getNombre());
        vacuna.setDescripcion(request.getDescripcion());
        vacuna.setFechaAplicacion(LocalDateTime.now());
        vacuna.setProximaAplicacion(LocalDateTime.now().plusYears(1));
        vacuna.setMascota(mascota);
        vacuna.setEstado(CODEPOS);
        return repository.save(vacuna);
    }

    public List<VacunaModel>listar(){ return repository.findByEstado(CODEPOS);}

    public HistorialVacunaDTO historialVacuna(Integer idMascota){
        MascotasModel mastoca = mascotasRepository.findById(idMascota)
                .orElseThrow(()-> new RuntimeException(MSG18));
        List<VacunaModel> vacuna = repository
                .findByMascotaIdMascotaAndEstado(idMascota,CODEPOS);
        List<VacunaResponseDTO> vacunasDTO = vacuna.stream().map(v ->{
            VacunaResponseDTO dto = new VacunaResponseDTO();
            dto.setIdVacuna(v.getIdVacuna());
            dto.setNombre(v.getNombrevacuna());
            dto.setFechaAplicacion(v.getFechaAplicacion());
            dto.setProximaAplicacion(v.getProximaAplicacion());
            return dto;
        }).toList();

        HistorialVacunaDTO historial = new HistorialVacunaDTO();
        historial.setIdMascota(mastoca.getIdMascota());
        historial.setNombre(mastoca.getNombre());
        historial.setVacunas(vacunasDTO);

        return historial;
    }

    public VacunaModel buscarPorId(Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException(MSG19));
    }

    public void eliminar(Integer id){
        VacunaModel vacuna = buscarPorId(id);
        vacuna.setEstado(CODENEG);
        repository.save(vacuna);
    }

    public List<ReporteMascotasVacunaDTO> reporteMascotasVacunadas(){
        return repository.mascotasVacunadas();
    }
}
