package org.example.api.dto;

import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimulationResultDTO {
    private Long simulationResultId;
    private int day;
    private int infected;
    private int susceptible;
    private int deceased;
    private int recovered;

    private SimulationDTO simulationDTO;
}
