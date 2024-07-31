package org.example.business.dao;

import org.example.domain.Simulation;

import java.util.List;
import java.util.Optional;

public interface SimulationDAO {

    Simulation save(Simulation simulation);

    List<Simulation> findAll();

    Optional<Simulation> findById(Long id);

    void deleteById(Long id);
}
