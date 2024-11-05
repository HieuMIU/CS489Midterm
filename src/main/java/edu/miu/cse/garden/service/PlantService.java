package edu.miu.cse.garden.service;

import edu.miu.cse.garden.model.Plant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlantService {
    Optional<Plant> addNewPlant(Plant plant);

    List<Plant> getAllSortByName();

    List<Plant> getAllSortByPlantDate();

    Plant findByName(String plantName);

    Optional<Plant> updatePlant(Plant plant);

    void deletePlant(Plant plant);
}
