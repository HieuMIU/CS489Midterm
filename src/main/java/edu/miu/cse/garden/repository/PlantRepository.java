package edu.miu.cse.garden.repository;

import edu.miu.cse.garden.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
    List<Plant> findAllByOrderByName();
    List<Plant> findAllByOrderByPlantDate();
    Optional<Plant> findByName(String name);
}
