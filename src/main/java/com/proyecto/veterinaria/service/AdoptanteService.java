package com.proyecto.veterinaria.service;
import com.proyecto.veterinaria.models.AdoptanteModel;
import com.proyecto.veterinaria.models.MascotasModel;
import com.proyecto.veterinaria.repository.AdoptanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.proyecto.veterinaria.util.UtilConstants.*;

@Service
@RequiredArgsConstructor
public class AdoptanteService {
    private final AdoptanteRepository repository;

    public AdoptanteModel guardar(AdoptanteModel adoptante){return repository.save(adoptante);}

    public List<AdoptanteModel> listar(){return repository.findByEstado(CODEPOS);}

    public AdoptanteModel buscarPorId(Integer id){
        return repository.findById(id).orElseThrow(()->new RuntimeException(MSG17));
    }

    public AdoptanteModel actualizar(Integer id, AdoptanteModel request){
        AdoptanteModel adoptante =buscarPorId(id);
        adoptante.setNombre(request.getNombre());
        adoptante.setApellido(request.getApellido());
        adoptante.setTelefono(request.getTelefono());
        adoptante.setDireccion(request.getDireccion());

        return repository.save(adoptante);
    }

    public void eliminar(Integer id){
        AdoptanteModel adoptante = buscarPorId(id);
        adoptante.setEstado(CODENEG);
        repository.save(adoptante);
    }


}
