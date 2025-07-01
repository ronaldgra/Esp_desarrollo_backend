package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import com.example.entity.Estado;
import com.example.entity.PlanAccion;
import com.example.entity.Prioridad;

@DataJpaTest
@Import(PlanAccionService.class)
class PlanAccionServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlanAccionService service;


    @Test
    void getPlanesVencidos_returnsRecordsBeforeToday() {
        LocalDate today = LocalDate.now();

        PlanAccion vencido = PlanAccion.builder()
                .titulo("Vencido")
                .fechaVencimiento(today.minusDays(1))
                .prioridad(Prioridad.ALTA)
                .estado(Estado.ABIERTO)
                .build();
        entityManager.persist(vencido);

        PlanAccion vigente = PlanAccion.builder()
                .titulo("Vigente")
                .fechaVencimiento(today.plusDays(1))
                .prioridad(Prioridad.MEDIA)
                .estado(Estado.ABIERTO)
                .build();
        entityManager.persist(vigente);

        entityManager.flush();

        var resultados = service.getPlanesVencidos(today);

        assertThat(resultados)
                .containsExactly(vencido)
                .doesNotContain(vigente);
    }
}
