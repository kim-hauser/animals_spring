package com.example.animals.controllers;

import com.example.animals.data.VolunteerRepository;
import com.example.animals.models.Volunteer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class VolunteerController {

    private final VolunteerRepository volunteerRepository;

    public VolunteerController(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @GetMapping("/volunteers/new")
    public String displayAddVolunteerForm(Model model) {
        model.addAttribute("volunteer", new Volunteer());
        return "add-volunteer";
    }

    @PostMapping("/volunteers")
    public String processAddVolunteerForm(@ModelAttribute Volunteer volunteer) {
        volunteerRepository.save(volunteer);
        return "redirect:/volunteers/new";
    }
}