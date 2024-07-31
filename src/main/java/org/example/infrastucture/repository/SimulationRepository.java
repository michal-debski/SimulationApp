package org.example.infrastucture.repository;

import lombok.AllArgsConstructor;
import org.example.business.dao.SimulationDAO;
import org.example.domain.Simulation;
import org.example.infrastucture.entity.SimulationEntity;
import org.example.infrastucture.repository.jpa.SimulationJpaRepository;
import org.example.infrastucture.repository.mapper.SimulationEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SimulationRepository implements SimulationDAO {


    private final SimulationEntityMapper simulationEntityMapper;
    private final SimulationJpaRepository simulationJpaRepository;


    @Override
    public Simulation save(Simulation simulation) {
        SimulationEntity simulationEntity = simulationEntityMapper.mapToEntity(simulation);
        SimulationEntity save = simulationJpaRepository.save(simulationEntity);
        return simulationEntityMapper.mapFromEntity(save);
    }

    @Override
    public List<Simulation> findAll() {
        List<SimulationEntity> simulationList = simulationJpaRepository.findAll();
        return simulationList.stream()
                .map(simulationEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public Optional<Simulation> findById(Long id) {
        return simulationJpaRepository
                .findById(id)
                .map(simulationEntityMapper::mapFromEntity);
    }

    @Override
    public void deleteById(Long id) {
        simulationJpaRepository.deleteById(id);
    }
}
