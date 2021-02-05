package com.sda.petclinicmanagement.dao;

public enum VetSpecialties {
    ANESTHESIA ("Anesthesia"),
    BEHAVIOR ("Behavior"),
    DENTISTRY ("Dentistry"),
    NUTRITION ("Nutrition");

    String specialization;

    VetSpecialties (String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return specialization;
    }
}
