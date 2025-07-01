package com.example.scheduler;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.dto.PlanAccionDTO;
import com.example.entity.PlanAccion;
import com.example.service.EmailService;
import com.example.service.PlanAccionService;

import lombok.RequiredArgsConstructor;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class AlertScheduler {

    private final PlanAccionService planAccionService;
    private final EmailService emailService;

    @Scheduled(cron = "0 0 7 * * *", zone = "America/Bogota")
    public void enviarAlertas() {
        LocalDate hoy = LocalDate.now(ZoneId.of("America/Bogota"));
        List<PlanAccion> planes = planAccionService.getPlanesPorVencer(15, hoy);
        List<PlanAccionDTO> dtos = planes.stream()
                .map(p -> PlanAccionDTO.builder()
                        .id(p.getId())
                        .titulo(p.getTitulo())
                        .descripcion(p.getDescripcion())
                        .fechaVencimiento(p.getFechaVencimiento())
                        .prioridad(p.getPrioridad())
                        .estado(p.getEstado())
                        .responsable(p.getResponsable())
                        .validador(p.getValidador())
                        .build())
                .collect(Collectors.toList());
        emailService.sendAlertas(dtos, Collections.emptyList());
    }
}
