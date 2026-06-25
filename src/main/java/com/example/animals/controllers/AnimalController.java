package com.example.animals.controllers;

import com.example.animals.data.AnimalRepository;
import com.example.animals.models.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/animals/new")
    public String displayAddAnimalForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "add-animal";
    }

    @PostMapping("/animals")
    public String processAddAnimalForm(@ModelAttribute Animal animal) {
        animalRepository.save(animal);
        return "redirect:/animals/new";
    }
}