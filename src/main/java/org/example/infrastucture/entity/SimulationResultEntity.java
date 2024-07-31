package org.example.infrastucture.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "simulationResultId")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "simulation_result")
public class SimulationResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "simulation_result_id")
    private Long simulationResultId;

    @Column(name = "day")
    private int day;
    @Column(name = "infected")
    private int infected;
    @Column(name = "susceptible")
    private int susceptible;
    @Column(name = "deceased")
    private int deceased;
    @Column(name = "recovered")
    private int recovered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "simulation_id")
    private SimulationEntity simulation;

}
