package com.sda.petclinicmanagement.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consults")
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private Veterinarian veterinarian;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column
    @Temporal(value = TemporalType.DATE)
    private Date date;

    @Column
    private String description;

    public Consult() {
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian vet) {
        this.veterinarian = vet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "id=" + id +
                ", veterinarian=" + veterinarian +
                ", pet=" + pet +
                ", date=" + date +
                ", description='" + description + '\'' +
                "}\n";
    }
}
