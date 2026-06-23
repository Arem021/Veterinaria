package com.proyecto.veterinaria.repository;

import com.proyecto.veterinaria.dto.HistorialVacunaDTO;
import com.proyecto.veterinaria.dto.ReporteMascotasVacunaDTO;
import com.proyecto.veterinaria.models.VacunaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacunasRepository extends JpaRepository<VacunaModel, Integer> {

    List<VacunaModel> findByMascotaIdMascotaAndEstado(Integer idMascota, Integer estado);
    List<VacunaModel> findByEstado(Integer estado);

    @Query("""
        SELECT new com.proyecto.veterinaria.dto.ReporteMascotasVacunaDTO(
            V.mascota.idMascota,
            V.mascota.nombre,
            V.mascota.especie,
            COUNT(V.idVacuna)
        )
        FROM VacunaModel V
        WHERE V.estado = 1
        AND V.mascota.estado = 1
        GROUP BY
            V.mascota.idMascota,
            V.mascota.nombre,
            V.mascota.especie
        ORDER BY COUNT(V.idVacuna) DESC
    """)
    List<ReporteMascotasVacunaDTO> mascotasVacunadas();
}
