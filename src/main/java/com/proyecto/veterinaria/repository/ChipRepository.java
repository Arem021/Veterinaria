package com.proyecto.veterinaria.repository;

import com.proyecto.veterinaria.models.ChipModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChipRepository extends JpaRepository<ChipModel, Integer> {
    List<ChipModel> findByEstado(Integer estado);

    List<ChipModel> findByMascotaIdMascotaAndEstado(Integer idMascota, Integer estado);
}
