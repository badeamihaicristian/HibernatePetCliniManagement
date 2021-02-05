package com.sda.petclinicmanagement.model;

import com.sda.petclinicmanagement.dao.PetType;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private PetType race;

    @Column
    @Temporal(value = TemporalType.DATE)
    private Date birthdate;

    @Column
    private boolean isVaccinated;

    @Column(name = "owner_name")
    private String ownerName;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private Veterinarian veterinarian;

    @OneToMany(mappedBy = "pet")
    private List<Consult> consults;

    public Pet() {
    }

    public PetType getRace() {
        return race;
    }

    public void setRace(PetType race) {
        this.race = race;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public List<Consult> getConsults() {
        return consults;
    }

    public void setConsults(List<Consult> consults) {
        this.consults = consults;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", race=" + race +
                ", birthdate=" + birthdate +
                ", isVaccinated=" + isVaccinated +
                ", ownerName='" + ownerName + '\'' +
                "}\n";
    }
}
