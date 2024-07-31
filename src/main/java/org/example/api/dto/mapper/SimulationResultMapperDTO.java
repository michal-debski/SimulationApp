package org.example.api.dto.mapper;

import org.example.api.dto.SimulationDTO;
import org.example.api.dto.SimulationResultDTO;
import org.example.domain.Simulation;
import org.example.domain.SimulationResult;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SimulationResultMapperDTO {
    default SimulationResultDTO toDTO(SimulationResult simulationResult){
        return SimulationResultDTO.builder()
                .simulationResultId(simulationResult.getSimulationResultId())
                .susceptible(simulationResult.getSusceptible())
                .deceased(simulationResult.getDeceased())
                .infected(simulationResult.getInfected())
                .recovered(simulationResult.getRecovered())
                .day(simulationResult.getDay())
                .simulationDTO(SimulationDTO.builder()
                        .simulationId(simulationResult.getSimulation().getSimulationId())
                        .name(simulationResult.getSimulation().getName())
                        .simulationDays(simulationResult.getSimulation().getSimulationDays())
                        .populationSize(simulationResult.getSimulation().getPopulationSize())
                        .initialInfected(simulationResult.getSimulation().getInitialInfected())
                        .infectionRate(simulationResult.getSimulation().getInfectionRate())
                        .mortalityRate(simulationResult.getSimulation().getMortalityRate())
                        .recoveryDays(simulationResult.getSimulation().getRecoveryDays())
                        .build())
                .build();
    }
    default SimulationResult fromDTO(SimulationResultDTO simulationResultDTO){
        return SimulationResult.builder()
                .simulationResultId(simulationResultDTO.getSimulationResultId())
                .susceptible(simulationResultDTO.getSusceptible())
                .deceased(simulationResultDTO.getDeceased())
                .infected(simulationResultDTO.getInfected())
                .recovered(simulationResultDTO.getRecovered())
                .day(simulationResultDTO.getDay())
                .simulation(Simulation.builder()
                        .simulationId(simulationResultDTO.getSimulationDTO().getSimulationId())
                        .name(simulationResultDTO.getSimulationDTO().getName())
                        .simulationDays(simulationResultDTO.getSimulationDTO().getSimulationDays())
                        .populationSize(simulationResultDTO.getSimulationDTO().getPopulationSize())
                        .initialInfected(simulationResultDTO.getSimulationDTO().getInitialInfected())
                        .infectionRate(simulationResultDTO.getSimulationDTO().getInfectionRate())
                        .mortalityRate(simulationResultDTO.getSimulationDTO().getMortalityRate())
                        .recoveryDays(simulationResultDTO.getSimulationDTO().getRecoveryDays())
                        .build())
                .build();
    }
}
