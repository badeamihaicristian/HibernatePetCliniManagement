package com.sda.petclinicmanagement.model;

import com.sda.petclinicmanagement.dao.VetSpecialties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "veterinarians")
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column
    private String address;

    @Column
    @Enumerated(value = EnumType.STRING)
    private VetSpecialties speciality;

    @OneToMany(mappedBy = "veterinarian")
    private List<Pet> pets;

    @OneToMany(mappedBy = "veterinarian")
    private List<Consult> consults;

    public Veterinarian() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public VetSpecialties getSpeciality() {
        return speciality;
    }

    public void setSpeciality(VetSpecialties speciality) {
        this.speciality = speciality;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Consult> getConsults() {
        return consults;
    }

    public void setConsults(List<Consult> consults) {
        this.consults = consults;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", speciality=" + speciality +
                "}\n";
    }
}
