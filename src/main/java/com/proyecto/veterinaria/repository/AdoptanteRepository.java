package com.proyecto.veterinaria.repository;


import com.proyecto.veterinaria.models.AdoptanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptanteRepository extends JpaRepository<AdoptanteModel, Integer> {
    List<AdoptanteModel> findByEstado(Integer estado);
}
