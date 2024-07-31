package org.example.api.dto;

import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimulationDTO {
    private Long simulationId;
    private String name;
    private int populationSize;
    private int initialInfected;
    private double infectionRate;
    private double mortalityRate;
    private int recoveryDays;
    private int deathDays;
    private int simulationDays;
}
