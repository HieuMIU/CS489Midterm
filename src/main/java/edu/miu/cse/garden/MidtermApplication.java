package edu.miu.cse.garden;

import edu.miu.cse.garden.model.Plant;
import edu.miu.cse.garden.model.Garden;
import edu.miu.cse.garden.service.PlantService;
import edu.miu.cse.garden.service.GardenService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class MidtermApplication {

    private final GardenService gardenService;
    private final PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(MidtermApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {

            Garden garden = new Garden(1, "Vegetable Patch", 50.0);
            gardenService.addNewGarden(garden);

            garden = new Garden(2, "Herb Garden", 20.0);
            gardenService.addNewGarden(garden);

            Plant plant = new Plant(1, "Tomato", "Vegetable", LocalDate.of(2024, 3,10));
            plant.setGarden(gardenService.findGardenByName("Vegetable Patch").get());
            plantService.addNewPlant(plant);

            plant = new Plant(2, "Carrot", "Vegetable", LocalDate.of(2024,2,20));
            plant.setGarden(gardenService.findGardenByName("Vegetable Patch").get());
            plantService.addNewPlant(plant);

            plant = new Plant(3, "Basil", "Herb", LocalDate.of(2024, 4,5));
            plant.setGarden(gardenService.findGardenByName("Herb Garden").get());
            plantService.addNewPlant(plant);

            System.out.println("Display All Garden:");
            List<Garden> gardens = gardenService.getAll();
            gardens.forEach(System.out::println);

            System.out.println("Display All Plants (Sort By Name:");
            List<Plant> plants = plantService.getAllSortByName();
            plants.forEach(System.out::println);

            System.out.println("Display All Plants (Sort By Plant Date:");
            plants = plantService.getAllSortByPlantDate();
            plants.forEach(System.out::println);

            System.out.println("Add new plant Rose Manny into Herb Garden:");
            plant = new Plant(4, "Rose Manny", "Herb", LocalDate.of(2024, 11, 5));
            plant.setGarden(gardenService.findGardenByName("Herb Garden").get());
            plantService.addNewPlant(plant);
            System.out.println("Updated All Plant:");
            plants = plantService.getAllSortByName();
            plants.forEach(System.out::println);

            System.out.println("Update plant Rose Manny to Rose Marry");
            plant = plantService.findByName("Rose Manny");
            if(plant != null) {
                plant.setName("Rose Marry");
                plantService.updatePlant(plant);
                System.out.println("Updated plant: " + plant);
            }

            System.out.println("Delete plant Rose Marry");
            plant = plantService.findByName("Rose Marry");
            if(plant != null){
                plantService.deletePlant(plant);
                System.out.println("Updated All Plant:");
                plants = plantService.getAllSortByName();
                plants.forEach(System.out::println);
            }
        };
    }
}
