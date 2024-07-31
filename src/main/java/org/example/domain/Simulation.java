package org.example.domain;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@With
public class Simulation {
    Long simulationId;
    String name;
    Integer populationSize;
    Integer initialInfected;
    Double infectionRate;
    Double mortalityRate;
    Integer recoveryDays;
    Integer deathDays;
    Integer simulationDays;
}
