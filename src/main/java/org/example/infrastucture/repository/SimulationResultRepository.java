package org.example.infrastucture.repository;


import lombok.AllArgsConstructor;
import org.example.business.dao.SimulationResultDAO;
import org.example.domain.SimulationResult;
import org.example.infrastucture.entity.SimulationResultEntity;
import org.example.infrastucture.repository.jpa.SimulationResultJpaRepository;
import org.example.infrastucture.repository.mapper.SimulationResultEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SimulationResultRepository implements SimulationResultDAO {

    private final SimulationResultEntityMapper simulationResultEntityMapper;
    private final SimulationResultJpaRepository simulationResultJpaRepository;


    @Override
    public SimulationResult save(SimulationResult simulationResult) {
        SimulationResultEntity simulationResultEntity = simulationResultEntityMapper.mapToEntity(simulationResult);
        SimulationResultEntity toSave = simulationResultJpaRepository.saveAndFlush(simulationResultEntity);

        return simulationResultEntityMapper.mapFromEntity(toSave);
    }

    @Override
    public void saveAll(List<SimulationResult> results) {
        for (SimulationResult result : results) {
            SimulationResultEntity simulationResultEntity = simulationResultEntityMapper.mapToEntity(result);
            simulationResultJpaRepository.saveAndFlush(simulationResultEntity);
        }
    }
}
