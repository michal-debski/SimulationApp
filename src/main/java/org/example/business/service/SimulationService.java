package org.example.business.service;

import lombok.AllArgsConstructor;
import org.example.business.dao.SimulationDAO;
import org.example.business.dao.SimulationResultDAO;
import org.example.domain.Simulation;
import org.example.domain.SimulationResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SimulationService {


    private SimulationDAO simulationDAO;
    private SimulationResultDAO simulationResultDAO;

    public Simulation createSimulation(Simulation simulation) {
        simulationDAO.save(simulation);
        return simulation;
    }

    public List<Simulation> getAllSimulations() {
        return simulationDAO.findAll();
    }

    public Simulation getSimulationById(Long id) {
        return simulationDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Simulation not found"));
    }

    @Transactional
    public Simulation updateSimulation(Long id, Simulation updatedSimulation) {
        Simulation simulation = simulationDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Simulation not found"));
        simulation.setName(updatedSimulation.getName());
        simulation.setPopulationSize(updatedSimulation.getPopulationSize());
        simulation.setInitialInfected(updatedSimulation.getInitialInfected());
        simulation.setInfectionRate(updatedSimulation.getInfectionRate());
        simulation.setMortalityRate(updatedSimulation.getMortalityRate());
        simulation.setRecoveryDays(updatedSimulation.getRecoveryDays());
        simulation.setDeathDays(updatedSimulation.getDeathDays());
        simulation.setSimulationDays(updatedSimulation.getSimulationDays());
        simulationDAO.save(simulation);
        return simulation;
    }

    public void deleteSimulation(Long id) {
        simulationDAO.deleteById(id);
    }

    public List<SimulationResult> runSimulation(Simulation simulation) {
        simulationDAO.save(simulation);
        List<SimulationResult> results = simulate(simulation);
        saveSimulationResults(simulation, results);
        return results;
    }

    private List<SimulationResult> simulate(Simulation simulation) {
        List<SimulationResult> results = new ArrayList<>();


        int initialInfected = simulation.getInitialInfected();
        int populationSize = simulation.getPopulationSize();
        int currentInfected = initialInfected;
        int currentSusceptible = populationSize - initialInfected;
        int totalDeaths = 0;
        int totalRecoveries = 0;


        int[] infectedDays = new int[simulation.getSimulationDays() + 1];

        for (int i = 0; i <= simulation.getSimulationDays(); i++) {
            infectedDays[i] = 0;
        }
        for (int i = 1; i <= simulation.getRecoveryDays(); i++) {
            infectedDays[i] = initialInfected;
        }

        for (int day = 1; day <= simulation.getSimulationDays(); day++) {
            int newDeaths = 0;
            int newRecoveries = 0;

            for (int i = 1; i < day; i++) {
                if (day - i >= simulation.getDeathDays()) {
                    newDeaths += (int) (infectedDays[i] * simulation.getMortalityRate());
                }
                if (day - i >= simulation.getRecoveryDays()) {
                    newRecoveries += (int) (infectedDays[i] * (1 - simulation.getMortalityRate()));
                }
            }

            newDeaths = Math.min(newDeaths, currentInfected);
            newRecoveries = Math.min(newRecoveries, currentInfected - newDeaths);

            currentInfected -= newDeaths + newRecoveries;
            totalDeaths += newDeaths;
            totalRecoveries += newRecoveries;

            int newInfections = Math.min(currentSusceptible, (int) Math.round(currentSusceptible * simulation.getInfectionRate()));
            currentInfected += newInfections;
            currentSusceptible -= newInfections;

            for (int i = simulation.getSimulationDays(); i >= 1; i--) {
                if (i > 1) {
                    infectedDays[i] = infectedDays[i - 1];
                } else {
                    infectedDays[i] = newInfections;
                }
            }
            SimulationResult result = SimulationResult.builder()
                    .simulation(simulation)
                    .day(day)
                    .susceptible(currentSusceptible)
                    .deceased(totalDeaths)
                    .recovered(totalRecoveries)
                    .infected(currentInfected)
                    .build();
            results.add(result);
        }

        return results;
    }

    private void saveSimulationResults(Simulation simulation, List<SimulationResult> results) {
        for (SimulationResult result : results) {
            result.setSimulation(simulation);
        }
        simulationResultDAO.saveAll(results);
    }
}
