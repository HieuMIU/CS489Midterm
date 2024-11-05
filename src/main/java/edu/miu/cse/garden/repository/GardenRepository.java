package edu.miu.cse.garden.repository;

import edu.miu.cse.garden.model.Garden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GardenRepository extends JpaRepository<Garden, Integer> {
    Optional<Garden> findByName(String gardenName);
    List<Garden> findAll();
}
