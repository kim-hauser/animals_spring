package com.example.animals;

import com.example.animals.data.VolunteerRepository;
import com.example.animals.models.Volunteer;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerApiController {

    private final VolunteerRepository volunteerRepository;

    public VolunteerApiController(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
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
}