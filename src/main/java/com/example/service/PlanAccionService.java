package com.example.service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.entity.Estado;
import com.example.entity.PlanAccion;
import com.example.repository.PlanAccionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanAccionService {

    private final PlanAccionRepository repository;

    public List<PlanAccion> getPlanesVencidos(LocalDate hoy) {
        List<PlanAccion> resultado = new ArrayList<>();
        resultado.addAll(repository.findByEstadoAndFechaVencimientoBefore(Estado.ABIERTO, hoy));
        resultado.addAll(repository.findByEstadoAndFechaVencimientoBefore(Estado.EN_PROGRESO, hoy));
        return resultado;
    }

    public List<PlanAccion> getPlanesPorVencer(int dias, LocalDate hoy) {
        LocalDate limite = hoy.plusDays(dias);
        return repository.findAll().stream()
                .filter(p -> !p.getFechaVencimiento().isBefore(hoy))
                .filter(p -> !p.getFechaVencimiento().isAfter(limite))
                .filter(p -> p.getEstado() != Estado.CERRADO)
                .toList();
    }

    public void guardar(PlanAccion plan) {
        repository.save(plan);
    }
}
