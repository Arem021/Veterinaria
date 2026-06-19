package com.proyecto.veterinaria.repository;

import com.proyecto.veterinaria.models.CitaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<CitaModel, Integer> {
    List<CitaModel> findByEstado(Integer estado);
}
