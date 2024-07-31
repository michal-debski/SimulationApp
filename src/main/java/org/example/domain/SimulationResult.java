package org.example.domain;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@With
public class SimulationResult {
    Long simulationResultId;
    Integer day;
    Integer infected;
    Integer susceptible;
    Integer deceased;
    Integer recovered;
    Simulation simulation;
}
