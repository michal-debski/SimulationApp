package org.example.infrastucture.repository.mapper;

import org.example.domain.Simulation;
import org.example.domain.SimulationResult;
import org.example.infrastucture.entity.SimulationEntity;
import org.example.infrastucture.entity.SimulationResultEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SimulationEntityMapper {

    SimulationEntity mapToEntity(Simulation simulation);

    Simulation mapFromEntity(SimulationEntity simulationDayEntity);

    SimulationResultEntity mapToEntity(SimulationResult simulationResult);

    SimulationResult mapFromEntity(SimulationResultEntity simulationResultEntity);
}
