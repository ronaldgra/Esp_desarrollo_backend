package com.example.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Estado;
import com.example.entity.PlanAccion;
import com.example.entity.Prioridad;

public interface PlanAccionRepository extends JpaRepository<PlanAccion, Long> {

    List<PlanAccion> findByEstadoAndFechaVencimientoBefore(Estado estado, LocalDate fechaLimite);

    List<PlanAccion> findByPrioridadOrderByFechaVencimientoAsc(Prioridad prioridad);
}
