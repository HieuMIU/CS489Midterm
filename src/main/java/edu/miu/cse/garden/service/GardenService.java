package edu.miu.cse.garden.service;

import edu.miu.cse.garden.model.Garden;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GardenService {
    Optional<Garden> addNewGarden(Garden publisher);
    Optional<Garden> findGardenByName(String gardenName);
    List<Garden> getAll();
}
