package org.example.infrastucture.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "simulationId")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "simulation")
public class SimulationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "simulation_id")
    private Long simulationId;
    @Column(name = "name")
    private String name;
    @Column(name = "population_size")
    private int populationSize;
    @Column(name = "initial_infected")
    private int initialInfected;
    @Column(name = "infection_rate")
    private double infectionRate;
    @Column(name = "mortality_rate")
    private double mortalityRate;
    @Column(name = "recovery_days")
    private int recoveryDays;
    @Column(name = "death_days")
    private int deathDays;
    @Column(name = "simulation_days")
    private int simulationDays;

    @OneToMany(mappedBy = "simulation", cascade = CascadeType.ALL)
    private List<SimulationResultEntity> simulationResultList;
}
