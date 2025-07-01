package com.example.dto;

import java.time.LocalDate;

import com.example.entity.Estado;
import com.example.entity.Prioridad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanAccionDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaVencimiento;
    private Prioridad prioridad;
    private Estado estado;
    private Long responsable;
    private Long validador;
}
