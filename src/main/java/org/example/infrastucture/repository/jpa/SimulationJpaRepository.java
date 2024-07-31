package org.example.infrastucture.repository.jpa;

import org.example.infrastucture.entity.SimulationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulationJpaRepository extends JpaRepository<SimulationEntity, Long> {
}
