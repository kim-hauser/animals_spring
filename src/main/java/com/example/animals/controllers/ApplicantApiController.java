package com.example.animals;

import com.example.animals.data.ApplicantRepository;
import com.example.animals.models.Applicant;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantApiController {

    private final ApplicantRepository applicantRepository;

    public ApplicantApiController(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Applicant> getApplicant(@PathVariable Long id) {
        return applicantRepository.findById(id);
    }

    @PostMapping
    public Applicant addApplicant(@RequestBody Applicant applicant) {
        return applicantRepository.save(applicant);
    }
}
