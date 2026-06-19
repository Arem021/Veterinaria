package com.proyecto.veterinaria.repository;

import com.proyecto.veterinaria.models.VacunaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacunasRepository extends JpaRepository<VacunaModel, Integer> {
    List<VacunaModel>findByEstado(Integer estado);
}
