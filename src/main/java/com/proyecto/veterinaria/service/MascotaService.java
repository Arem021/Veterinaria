package com.proyecto.veterinaria.service;

import com.proyecto.veterinaria.dto.MascotaRequestDTO;
import com.proyecto.veterinaria.dto.MascotaResponseDTO;
import com.proyecto.veterinaria.models.AdoptanteModel;
import com.proyecto.veterinaria.models.MascotasModel;
import com.proyecto.veterinaria.repository.AdoptanteRepository;
import com.proyecto.veterinaria.repository.MascotasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.proyecto.veterinaria.util.UtilConstants.*;

@Service
@RequiredArgsConstructor
public class MascotaService {
    private final MascotasRepository mascotasRepository;
    private final AdoptanteRepository adoptanteRepository;

    public MascotasModel guardar(MascotaRequestDTO request){
        AdoptanteModel adoptante;
        if (request.getIdAdoptante() == null) {
            adoptante = adoptanteRepository.findById(1)
                    .orElseThrow(() -> new RuntimeException(MSG17));
        } else {
            adoptante = adoptanteRepository.findById(request.getIdAdoptante())
                    .orElseThrow(() -> new RuntimeException(MSG17));

            if (adoptante.getEstado().equals(CODENEG)) {
                throw new RuntimeException(MSG22);
            }
        }

        MascotasModel mascota = new MascotasModel();
        mascota.setNombre(request.getNombre());
        mascota.setEspecie(request.getEspecie());
        mascota.setRaza(request.getRaza());
        mascota.setEdad(request.getEdad());
        mascota.setSexo(request.getSexo());
        mascota.setAdoptante(adoptante);
        mascota.setEstado(CODEPOS);
        return mascotasRepository.save(mascota);

    }

    public List<MascotasModel>listar(){
        return mascotasRepository.findByEstado(CODEPOS);
    }

    public List<MascotasModel> listarMascotasPorAdoptante(Integer idAdoptante){
        adoptanteRepository.findById(idAdoptante).orElseThrow(()-> new RuntimeException(MSG17));
        return mascotasRepository.findByAdoptante_IdAdoptanteAndEstado(idAdoptante,CODEPOS);
    }

    public MascotasModel buscarPorId(Integer id){
        return mascotasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(MSG18));
    }

    public MascotasModel actualizar(Integer id, MascotaRequestDTO request){
        MascotasModel mascota = buscarPorId(id);
        mascota.setNombre(request.getNombre());
        mascota.setEspecie(request.getEspecie());
        mascota.setRaza(request.getRaza());
        mascota.setEdad(request.getEdad());
        mascota.setSexo(request.getSexo());

        return mascotasRepository.save(mascota);
    }

    public void eliminar(Integer id){
        MascotasModel mascota = buscarPorId(id);
        mascota.setEstado(CODENEG);
        mascotasRepository.save(mascota);
    }
}
