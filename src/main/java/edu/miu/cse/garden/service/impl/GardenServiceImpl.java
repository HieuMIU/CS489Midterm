package edu.miu.cse.garden.service.impl;

import edu.miu.cse.garden.model.Garden;
import edu.miu.cse.garden.repository.GardenRepository;
import edu.miu.cse.garden.service.GardenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService {

    private final GardenRepository gardenRepository;

    @Override
    public Optional<Garden> addNewGarden(Garden garden) {
        return Optional.of(gardenRepository.save(garden));
    }

    @Override
    public Optional<Garden> findGardenByName(String gardenName) {
        return gardenRepository.findByName(gardenName);
    }

    @Override
    public List<Garden> getAll() {
        return gardenRepository.findAll();
    }
}
