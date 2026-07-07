package com.example.animals.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Applicant {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String phoneNumber;

    @JsonManagedReference("applicant-applications")
    @OneToMany(mappedBy = "applicant")
    private List<AdoptionApplication> applications = new ArrayList<>();

    public Applicant() {
    }

    public Applicant(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<AdoptionApplication> getApplications() {
        return applications;
    }

    public void setApplications(List<AdoptionApplication> applications) {
        this.applications = applications;
    }
}