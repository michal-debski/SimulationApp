package org.example.business.dao;

import org.example.domain.SimulationResult;

import java.util.List;

public interface SimulationResultDAO {

    SimulationResult save(SimulationResult simulationResult);
    void saveAll(List<SimulationResult> results);
}
