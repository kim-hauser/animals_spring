package com.example.animals.controllers;

import com.example.animals.data.ApplicantRepository;
import com.example.animals.models.Applicant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ApplicantController {

    private final ApplicantRepository applicantRepository;

    public ApplicantController(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @GetMapping("/applicants/new")
    public String displayAddApplicantForm(Model model) {
        model.addAttribute("applicant", new Applicant());
        return "add-applicant";
    }

    @PostMapping("/applicants")
    public String processAddApplicantForm(@ModelAttribute Applicant applicant) {
        applicantRepository.save(applicant);
        return "redirect:/applicants/new";
    }
}