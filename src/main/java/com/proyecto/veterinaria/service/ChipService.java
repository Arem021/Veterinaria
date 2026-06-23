package com.proyecto.veterinaria.service;

import com.proyecto.veterinaria.dto.ChipRequestDTO;
import com.proyecto.veterinaria.models.ChipModel;
import com.proyecto.veterinaria.models.MascotasModel;
import com.proyecto.veterinaria.repository.ChipRepository;
import com.proyecto.veterinaria.repository.MascotasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.proyecto.veterinaria.util.UtilConstants.*;

@Service
@AllArgsConstructor
public class ChipService {
    private final ChipRepository chipRepository;
    private final MascotasRepository mascotasRepository;

    public ChipModel guardar(ChipRequestDTO request){
        MascotasModel mascota = mascotasRepository.findById(request.getIdMascota())
                .orElseThrow(()->new RuntimeException(MSG18));
        if (mascota.getEstado().equals(CODENEG)){
            throw new RuntimeException(MSG23);
        }

        List<ChipModel> chipsActivos = chipRepository.findByMascotaIdMascotaAndEstado(request.getIdMascota(), CODEPOS);
        if (!chipsActivos.isEmpty()){
            throw new RuntimeException(MSG24);
        }

        ChipModel chip = new ChipModel();
        chip.setCodigoChip(request.getCodigoChip());
        chip.setFechaImplementacion(LocalDateTime.now());
        chip.setFabricante(request.getFabricante());
        chip.setMascota(mascota);
        chip.setEstado(CODEPOS);

        return chipRepository.save(chip);

    }

    public List<ChipModel> listar(){return chipRepository.findByEstado(CODEPOS);}

    public ChipModel buscarPorId(Integer id){
        return chipRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(MSG20));
    }

    public void eliminar(Integer id){
        ChipModel chip = new ChipModel();
        chip.setEstado(CODENEG);
        chipRepository.save(chip);
    }
}
