CREATE TABLE simulation_result (
    simulation_result_id SERIAL PRIMARY KEY,
    day INTEGER NOT NULL,
    infected INTEGER NOT NULL,
    susceptible INTEGER NOT NULL,
    deceased INTEGER NOT NULL,
    recovered INTEGER NOT NULL,
    simulation_id BIGINT NOT NULL,
    CONSTRAINT fk_simulation
        FOREIGN KEY (simulation_id)
        REFERENCES simulation(simulation_id)
        ON DELETE CASCADE
);