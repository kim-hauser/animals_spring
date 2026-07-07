package com.example.animals.controllers;

import com.example.animals.data.AnimalRepository;
import com.example.animals.data.VolunteerRepository;
import com.example.animals.models.Animal;
import com.example.animals.models.Volunteer;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerApiController {

    private final VolunteerRepository volunteerRepository;
    private final AnimalRepository animalRepository;

    public VolunteerApiController(
            VolunteerRepository volunteerRepository,
            AnimalRepository animalRepository
    ) {
        this.volunteerRepository = volunteerRepository;
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Volunteer> getVolunteer(@PathVariable Long id) {
        return volunteerRepository.findById(id);
    }

    @PostMapping
    public Volunteer addVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    @PostMapping("/assign")
    public Volunteer assignAnimalToVolunteer(@RequestBody VolunteerAnimalRequest request) {
        Volunteer volunteer = volunteerRepository.findById(request.getVolunteerId()).get();
        Animal animal = animalRepository.findById(request.getAnimalId()).get();

        volunteer.getAnimals().add(animal);
        animal.getVolunteers().add(volunteer);

        volunteerRepository.save(volunteer);
        animalRepository.save(animal);

        return volunteer;
    }
}

class VolunteerAnimalRequest {

    private Long volunteerId;
    private Long animalId;

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }
}