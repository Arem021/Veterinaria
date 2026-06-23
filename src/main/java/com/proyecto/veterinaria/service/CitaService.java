package com.proyecto.veterinaria.service;

import com.proyecto.veterinaria.dto.CitaRequestDTO;
import com.proyecto.veterinaria.models.AdoptanteModel;
import com.proyecto.veterinaria.models.CitaModel;
import com.proyecto.veterinaria.models.MascotasModel;
import com.proyecto.veterinaria.models.VacunaModel;
import com.proyecto.veterinaria.repository.CitaRepository;
import com.proyecto.veterinaria.repository.MascotasRepository;
import com.proyecto.veterinaria.repository.VacunasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.proyecto.veterinaria.util.UtilConstants.*;

@Service
@AllArgsConstructor
public class CitaService {
    private final CitaRepository citaRepository;
    private final MascotasRepository mascotasRepository;
    private final VacunasRepository vacunasRepository;

    public CitaModel guardar(CitaRequestDTO request){
        MascotasModel mascota = mascotasRepository.findById(request.getIdMascota())
                .orElseThrow(()-> new RuntimeException(MSG18));
        if (mascota.getEstado().equals(CODENEG)){
            throw new RuntimeException(MSG23);
        }

        AdoptanteModel adoptante = mascota.getAdoptante();
        if (adoptante == null){
            throw new RuntimeException(MSG25);
        }
        if (adoptante.getEstado().equals(CODENEG)){
            throw new RuntimeException(MSG22);
        }

        List<VacunaModel> vacunas = vacunasRepository
                .findByMascotaIdMascotaAndEstado(request.getIdMascota(), CODEPOS);
        if (vacunas.isEmpty()){
            throw new RuntimeException(MSG26);
        }

        CitaModel cita = new CitaModel();
        cita.setIdMascota(mascota);
        cita.setFechaCita(request.getFechaCita());
        cita.setMotivo(request.getMotivo());
        cita.setObservaciones(request.getObservaciones());
        cita.setEstatus(CITA_PROGRAMADA);
        cita.setEstado(CODEPOS);

        return citaRepository.save(cita);
    }

    public List<CitaModel> listar(){
        return citaRepository.findByEstado(CODEPOS);
    }

    public CitaModel buscarPorId(Integer id){
        return citaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(MSG21));
    }

    public  void cancelar(Integer id){
        CitaModel cita = buscarPorId(id);

        if (cita.getEstado().equals(CODENEG)){
            throw new RuntimeException(MSG27);
        }
        cita.setEstatus(CITA_CANCELADA);
        cita.setEstado(CODENEG);
        citaRepository.save(cita);
    }
}
