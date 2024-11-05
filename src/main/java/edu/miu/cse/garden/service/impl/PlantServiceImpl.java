package edu.miu.cse.garden.service.impl;

import edu.miu.cse.garden.model.Plant;
import edu.miu.cse.garden.repository.PlantRepository;
import edu.miu.cse.garden.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    @Override
    public Optional<Plant> addNewPlant(Plant plant) {
        return Optional.of(plantRepository.save(plant));
    }

    @Override
    public List<Plant> getAllSortByName() {
        return plantRepository.findAllByOrderByName();
    }

    @Override
    public List<Plant> getAllSortByPlantDate() {
        return plantRepository.findAllByOrderByPlantDate();
    }

    @Override
    public Plant findByName(String plantName) {
        return plantRepository.findByName(plantName).get();
    }

    @Override
    public Optional<Plant> updatePlant(Plant plant) {
        return Optional.of(plantRepository.save(plant));
    }

    @Override
    public void deletePlant(Plant plant) {
        plantRepository.delete(plant);
    }
}
