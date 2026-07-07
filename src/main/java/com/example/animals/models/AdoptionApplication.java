package com.example.animals.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AdoptionApplication {

    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference("applicant-applications")
    @ManyToOne
    private Applicant applicant;

    @JsonBackReference("animal-applications")
    @ManyToOne
    private Animal animal;

    public AdoptionApplication() {
    }

    public AdoptionApplication(Applicant applicant, Animal animal) {
        this.applicant = applicant;
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}