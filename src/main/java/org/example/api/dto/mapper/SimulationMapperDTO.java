package org.example.api.dto.mapper;

import org.example.api.dto.SimulationDTO;
import org.example.domain.Simulation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SimulationMapperDTO {
    default SimulationDTO toDTO(Simulation simulation){
        return SimulationDTO.builder()
                .simulationId(simulation.getSimulationId())
                .name(simulation.getName())
                .simulationDays(simulation.getSimulationDays())
                .deathDays(simulation.getDeathDays())
                .infectionRate(simulation.getInfectionRate())
                .initialInfected(simulation.getInitialInfected())
                .recoveryDays(simulation.getRecoveryDays())
                .mortalityRate(simulation.getMortalityRate())
                .populationSize(simulation.getPopulationSize())
                .build();
    }
    default Simulation fromDTO(SimulationDTO simulationDTO){
        return Simulation.builder()
                .simulationId(simulationDTO.getSimulationId())
                .name(simulationDTO.getName())
                .infectionRate(simulationDTO.getInfectionRate())
                .initialInfected(simulationDTO.getInitialInfected())
                .simulationDays(simulationDTO.getSimulationDays())
                .populationSize(simulationDTO.getPopulationSize())
                .recoveryDays(simulationDTO.getRecoveryDays())
                .mortalityRate(simulationDTO.getMortalityRate())
                .deathDays(simulationDTO.getDeathDays())
                .build();
    }
}
