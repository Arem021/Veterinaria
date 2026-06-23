package com.proyecto.veterinaria.repository;

import com.proyecto.veterinaria.models.AdoptanteModel;
import com.proyecto.veterinaria.models.MascotasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotasRepository extends JpaRepository<MascotasModel, Integer> {
    List<MascotasModel> findByEstado(Integer estado);
    List<MascotasModel> findByAdoptante_IdAdoptanteAndEstado(Integer idAdoptante, Integer estado);
}
