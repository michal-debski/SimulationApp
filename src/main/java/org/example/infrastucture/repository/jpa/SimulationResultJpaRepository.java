package org.example.infrastucture.repository.jpa;

import org.example.infrastucture.entity.SimulationResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulationResultJpaRepository extends JpaRepository<SimulationResultEntity, Long> {
}
