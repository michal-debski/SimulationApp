CREATE TABLE simulation (
    simulation_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    population_size INTEGER NOT NULL,
    initial_infected INTEGER NOT NULL,
    infection_rate DOUBLE PRECISION NOT NULL,
    mortality_rate DOUBLE PRECISION NOT NULL,
    recovery_days INTEGER NOT NULL,
    death_days INTEGER NOT NULL,
    simulation_days INTEGER NOT NULL
);

