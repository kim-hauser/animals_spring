package com.example.animals;
import com.example.animals.data.AnimalRepository;
import com.example.animals.models.Animal;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animals")
public class AnimalApiController {

    private final AnimalRepository animalRepository;

    public AnimalApiController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Animal> getAnimal(@PathVariable Long id) {
        return animalRepository.findById(id);
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }
}