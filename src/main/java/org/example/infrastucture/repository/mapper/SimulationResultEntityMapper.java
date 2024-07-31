package org.example.infrastucture.repository.mapper;

import org.example.domain.SimulationResult;
import org.example.infrastucture.entity.SimulationResultEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface SimulationResultEntityMapper {


    SimulationResultEntity mapToEntity(SimulationResult simulationResult);

    SimulationResult mapFromEntity(SimulationResultEntity simulationResultEntity);

    List<SimulationResultEntity> mapToEntity(Set<SimulationResult> simulationResult);

}
