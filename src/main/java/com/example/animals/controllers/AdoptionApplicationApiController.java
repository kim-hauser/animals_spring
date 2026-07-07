package com.example.animals.controllers;

import com.example.animals.data.AdoptionApplicationRepository;
import com.example.animals.data.AnimalRepository;
import com.example.animals.data.ApplicantRepository;
import com.example.animals.models.AdoptionApplication;
import com.example.animals.models.Animal;
import com.example.animals.models.Applicant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class AdoptionApplicationApiController {

    private final AdoptionApplicationRepository adoptionApplicationRepository;
    private final ApplicantRepository applicantRepository;
    private final AnimalRepository animalRepository;

    public AdoptionApplicationApiController(
            AdoptionApplicationRepository adoptionApplicationRepository,
            ApplicantRepository applicantRepository,
            AnimalRepository animalRepository
    ) {
        this.adoptionApplicationRepository = adoptionApplicationRepository;
        this.applicantRepository = applicantRepository;
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public List<AdoptionApplication> getAllApplications() {
        return adoptionApplicationRepository.findAll();
    }

    @PostMapping
    public AdoptionApplication addApplication(@RequestBody AdoptionApplicationRequest request) {
        Applicant applicant = applicantRepository.findById(request.getApplicantId()).get();
        Animal animal = animalRepository.findById(request.getAnimalId()).get();

        AdoptionApplication application = new AdoptionApplication(applicant, animal);

        return adoptionApplicationRepository.save(application);
    }
}

class AdoptionApplicationRequest {

    private Long applicantId;
    private Long animalId;

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }
}