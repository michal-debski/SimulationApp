package org.example.api.controller;

import lombok.AllArgsConstructor;
import org.example.api.dto.SimulationDTO;
import org.example.api.dto.SimulationResultDTO;
import org.example.api.dto.mapper.SimulationMapperDTO;
import org.example.api.dto.mapper.SimulationResultMapperDTO;
import org.example.business.service.SimulationService;
import org.example.domain.Simulation;
import org.example.domain.SimulationResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/simulations")
@AllArgsConstructor
public class SimulationController {
    private final SimulationService simulationService;
    private final SimulationMapperDTO simulationMapperDTO;
    private final SimulationResultMapperDTO simulationResultMapper;


    @PostMapping
    public ResponseEntity<SimulationDTO> createSimulation(@RequestBody SimulationDTO simulationDTO) {
        Simulation simulation = simulationMapperDTO.fromDTO(simulationDTO);
        Simulation createdSimulation = simulationService.createSimulation(simulation);
        SimulationDTO resultDTO = simulationMapperDTO.toDTO(createdSimulation);
        return ResponseEntity.ok(resultDTO);
    }

    @GetMapping
    public ResponseEntity<List<SimulationDTO>> getAllSimulations() {
        List<SimulationDTO> simulations = simulationService.getAllSimulations().stream()
                .map(simulationMapperDTO::toDTO)
                .toList();
        return ResponseEntity.ok(simulations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimulationDTO> getSimulationById(@PathVariable Long id) {
        Simulation simulation = simulationService.getSimulationById(id);
        SimulationDTO simulationDTO = simulationMapperDTO.toDTO(simulation);
        return ResponseEntity.ok(simulationDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimulationDTO> updateSimulation(@PathVariable Long id, @RequestBody SimulationDTO simulationDTO) {
        Simulation updatedSimulation = simulationMapperDTO.fromDTO(simulationDTO);
        Simulation simulation = simulationService.updateSimulation(id, updatedSimulation);
        SimulationDTO resultDTO = simulationMapperDTO.toDTO(simulation);
        return ResponseEntity.ok(resultDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSimulation(@PathVariable Long id) {
        simulationService.deleteSimulation(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/run")
    public ResponseEntity<List<SimulationResultDTO>> runSimulation(@PathVariable Long id) {
        Simulation simulation = simulationService.getSimulationById(id);
        List<SimulationResult> results = simulationService.runSimulation(simulation);
        List<SimulationResultDTO> resultDTOs = results.stream()
                .map(simulationResultMapper::toDTO)
                .toList();
        return ResponseEntity.ok(resultDTOs);
    }
}
