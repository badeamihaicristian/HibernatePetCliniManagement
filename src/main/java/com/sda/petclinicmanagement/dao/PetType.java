package com.sda.petclinicmanagement.dao;

public enum PetType {
    DOG ("Dog"),
    CAT ("Cat"),
    BIRD ("Bird"),
    REPTILE ("Reptile");

    String race;

    PetType (String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return race;
    }
}
