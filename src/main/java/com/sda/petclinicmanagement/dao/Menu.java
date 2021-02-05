package com.sda.petclinicmanagement.dao;

import com.sda.petclinicmanagement.model.Consult;
import com.sda.petclinicmanagement.model.Pet;
import com.sda.petclinicmanagement.model.Veterinarian;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private PetDao petDao = new PetDao();
    private VeterinarianDao vetDao = new VeterinarianDao();
    private ConsultDao consultDao = new ConsultDao();
    private Scanner scanner = new Scanner(System.in);
    int id;

    public void displayMenu() {
        System.out.print("Please choose one of the following options:\n" +
                "1. Add a new veterinarian\n" +
                "2. Delete a veterinarian\n" +
                "3. Update an existing veterinarian\n" +
                "4. Show all of the veterinarians\n" +
                "5. Add a new pet\n" +
                "6. Delete a pet\n" +
                "7. Update an existing pet\n" +
                "8. Show all of the pets\n" +
                "9. Add a new consult for an existing veterinarian and an existing pet\n" +
                "10. Update the description of a consult\n" +
                "11. Show all of the consults\n" +
                "12. Exit program\n");
    }

    public void chooseOption() {
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                addVet();
                break;
            case 2:
                deleteVet();
                break;
            case 3:
                updateVet();
                break;
            case 4:
                showAllVets();
                break;
            case 5:
                addPet();
                break;
            case 6:
                deletePet();
                break;
            case 7:
                updatePet();
                break;
            case 8:
                showAllPets();
                break;
            case 9:
                addConsult();
                break;
            case 10:
                updateDescriptionOfConsult();
                break;
            case 11:
                showAllConsults();
                break;
            case 12:
                System.out.println("The program will now exit. Bye bye!");
                break;
            default:
                System.out.println("Option is invalid");
                this.chooseOption();
        }
    }

    public void showAllVets() {
        System.out.println("These are all the veterinarians:\n");
        System.out.println(vetDao.getAllVeterinarians());
        System.out.println("Returning to the options menu..");
        displayMenu();
        chooseOption();
    }

    public void showAllPets() {
        System.out.println("These are all the pets:\n");
        System.out.println(petDao.getAllPets());
        System.out.println("Returning to the options menu..");
        displayMenu();
        chooseOption();
    }

    public void showAllConsults() {
        System.out.println("These are all the consults:\n");
        System.out.println(consultDao.getAllConsults());
        System.out.println("Returning to the options menu..");
        displayMenu();
        chooseOption();
    }

    public void deleteVet() {
        System.out.println("Here is a list of all the veterinarians");
        System.out.println(vetDao.getAllVeterinarians());
        System.out.print("Please enter the id of the veterinarian you want to delete: ");
        id = scanner.nextInt();
        vetDao.delete(vetDao.findById(id));
        System.out.println("The veterinarian with the id " + id + " has been succefully deleted from the database\n" +
                "Returning to the options menu...");
        displayMenu();
        chooseOption();
    }

    public void deletePet() {
        System.out.println("Here is a list of all the veterinarians");
        System.out.println(petDao.getAllPets());
        System.out.print("Please enter the id of the pet you want to delete: ");
        id = scanner.nextInt();
        petDao.delete(petDao.findById(id));
        System.out.println("The pet with the id " + id + " has been successfully deleted from the database\n" +
                "Returning to the options menu...");
        displayMenu();
        chooseOption();
    }

    public void updateDescriptionOfConsult() {
        System.out.println("Here is a list of all the consults");
        System.out.println(consultDao.getAllConsults());
        System.out.print("Please enter the id of the consult you want to update the description: ");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please write the new description of the consult:");
        String description = scanner.nextLine();
        consultDao.updateConsultDescription(consultDao.findById(id), description);
        System.out.println("The description of the consult with the id " + " has been successfully updated with the new description\n" +
                "Returning to the options menu...");
        displayMenu();
        chooseOption();
    }

    public void addVet() {
        Veterinarian vet = new Veterinarian();
        scanner.nextLine();
        System.out.println("Please enter all the details of the new pet:");
        System.out.print("First name: ");
        vet.setFirstname(scanner.nextLine());
        System.out.print("Last name: ");
        vet.setLastname(scanner.nextLine());
        System.out.print("Address: ");
        vet.setAddress(scanner.nextLine());
        System.out.print("Select one of the specialities bellow:\n" +
                "1. Anesthesia\n" +
                "2. Behavior\n" +
                "3. Dentistry\n" +
                "4. Nutrition\n");
        id = scanner.nextInt();
        switch (id) {
            case 1:
                vet.setSpeciality(VetSpecialties.ANESTHESIA);
                break;
            case 2:
                vet.setSpeciality(VetSpecialties.BEHAVIOR);
                break;
            case 3:
                vet.setSpeciality(VetSpecialties.DENTISTRY);
                break;
            case 4:
                vet.setSpeciality(VetSpecialties.NUTRITION);
                break;
            default:
                System.out.println("You haven't selected any of the options above");
        }
        List<Pet> petList = new ArrayList<>();
        List<Consult> consultList = new ArrayList<>();
        String yesOrNo;
        do {
            System.out.println("Here is a list of all the pets:");
            System.out.println(petDao.getAllPets());
            System.out.println("Please select the pet you want to add by entering the pet id");
            petList.add(petDao.findById(scanner.nextInt()));
            scanner.nextLine();
            System.out.println("Pet successfully added to list");
            System.out.println("Do you wish to add another pet? (y/n");
            yesOrNo = scanner.nextLine().toLowerCase();
        } while (yesOrNo.equals("y"));
        vet.setPets(petList);
        do {
            System.out.println("Here is a list of all the consults:");
            System.out.println(consultDao.getAllConsults());
            System.out.println("Please select the consult you want to add by entering the consult id");
            consultList.add(consultDao.findById(scanner.nextInt()));
            System.out.println("Consult successfully added to list");
            scanner.nextLine();
            System.out.println("Do you wish to add another consult? (y/n");
            yesOrNo = scanner.nextLine().toLowerCase();
        } while (yesOrNo.equals("y"));
        vet.setConsults(consultList);
        vetDao.add(vet);
        System.out.println("Veterinarian successfully added to the database. Returning to the options menu...");
        displayMenu();
        chooseOption();
    }

    public void updateVet() {
        Veterinarian vet;
        System.out.println("Here is a list of all the Veterinarians in the database:");
        System.out.println(vetDao.getAllVeterinarians());
        System.out.println("Please select the veterinarian you want to update by entering the id");
        vet = vetDao.findById(scanner.nextInt());
        System.out.print("Please select what field you want to update by selecting the number before it:\n" +
                "1. First name\n" +
                "2. Last name\n" +
                "3. Address\n" +
                "4. Speciality\n");
        id = scanner.nextInt();
        switch (id) {
            case 1:
                scanner.nextLine();
                System.out.print("Enter firstname: ");
                vet.setFirstname(scanner.nextLine());
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Enter lastname: ");
                vet.setLastname(scanner.nextLine());
                break;
            case 3:
                scanner.nextLine();
                System.out.print("Enter address: ");
                vet.setAddress(scanner.nextLine());
                break;
            case 4:
                int aux;
                System.out.print("Select one of the specialities bellow:\n" +
                        "1. Anesthesia\n" +
                        "2. Behavior\n" +
                        "3. Dentistry\n" +
                        "4. Nutrition\n");
                aux = scanner.nextInt();
                if (aux == 1) {
                    vet.setSpeciality(VetSpecialties.ANESTHESIA);
                } else if (aux == 2) {
                    vet.setSpeciality(VetSpecialties.BEHAVIOR);
                } else if (aux == 3) {
                    vet.setSpeciality(VetSpecialties.DENTISTRY);
                } else if (aux == 4) {
                    vet.setSpeciality(VetSpecialties.NUTRITION);
                } else System.out.println("You haven't selected a valid option. Speciality will not be updated");
                break;
        }
        vetDao.update(vet);
        System.out.println("The veterinarian has been updated successfully. Returning to the options menu...");
        displayMenu();
        chooseOption();
    }

    public void addPet() {
        Pet pet = new Pet();
        System.out.print("Select what kind of pet you want to add by selecting the number before it:\n" +
                "1. Dog\n" +
                "2. Cat\n" +
                "3. Bird\n" +
                "4. Reptile\n");
        id = scanner.nextInt();
        switch (id) {
            case 1:
                pet.setRace(PetType.DOG);
                break;
            case 2:
                pet.setRace(PetType.CAT);
                break;
            case 3:
                pet.setRace(PetType.BIRD);
                break;
            case 4:
                pet.setRace(PetType.REPTILE);
                break;
            default:
                System.out.println("You haven't selected any of the options above");
        }
        scanner.nextLine();
        System.out.print("Please enter the birthday of the pet (yyyy-mm-dd): ");
        pet.setBirthdate(Date.valueOf(scanner.nextLine()));
        System.out.print("Is the pet vaccinated? (true/false) ");
        pet.setVaccinated(scanner.nextBoolean());
        scanner.nextLine();
        System.out.print("Please enter the owner name: ");
        pet.setOwnerName(scanner.nextLine());
        System.out.println("Here is a list of all the veterinarians:");
        System.out.println(vetDao.getAllVeterinarians());
        System.out.print("Please select the veterinarian you want to associate with the pet by entering the id");
        pet.setVeterinarian(vetDao.findById(scanner.nextInt()));
        List<Consult> consultList = new ArrayList<>();
        String yesOrNo;
        do {
            System.out.println("Here is a list of all the consults:");
            System.out.println(consultDao.getAllConsults());
            System.out.println("Please select the consult you want to add by entering the consult id");
            consultList.add(consultDao.findById(scanner.nextInt()));
            scanner.nextLine();
            System.out.println("Consult successfully added to list");
            System.out.println("Do you wish to add another consult? (y/n");
            yesOrNo = scanner.nextLine().toLowerCase();
        } while (yesOrNo.equals("y"));
        pet.setConsults(consultList);
        petDao.add(pet);
        System.out.println("Pet successfully added to the database. Returning to the options menu...");
        displayMenu();
        chooseOption();
    }

    public void updatePet() {
        System.out.println("Here is a list of all the pets in the database:");
        System.out.println(petDao.getAllPets());
        System.out.println("Please select the pet you want to update by entering the id");
        Pet pet = petDao.findById(scanner.nextInt());
        System.out.print("Please select what field you want to update by selecting the number before it:\n" +
                "1. Race\n" +
                "2. Birthdate\n" +
                "3. Is Vaccinated\n" +
                "4. Owner name\n");
        id = scanner.nextInt();
        switch (id) {
            case 1:
                System.out.print("Please select the race by entering the number before it\n" +
                        "1. Dog\n" +
                        "2. Cat\n" +
                        "3. Bird\n" +
                        "4. Reptile\n");
                int aux = scanner.nextInt();
                if (aux == 1) {
                    pet.setRace(PetType.DOG);
                } else if (aux == 2) {
                    pet.setRace(PetType.CAT);
                } else if (aux == 3) {
                    pet.setRace(PetType.BIRD);
                } else if (aux == 4) {
                    pet.setRace(PetType.REPTILE);
                } else System.out.println("You haven't selected a valid option. Race will not be updated");
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Enter the birthday (yyyy-mm-dd): ");
                pet.setBirthdate(Date.valueOf(scanner.nextLine()));
                break;
            case 3:
                scanner.nextLine();
                System.out.print("Is the pet vaccinated? (true/false)");
                pet.setVaccinated(scanner.nextBoolean());
                break;
            case 4:
                scanner.nextLine();
                System.out.print("Enter owner name: ");
                pet.setOwnerName(scanner.nextLine());
                break;
            default:
                System.out.println("You haven't selected any option");
        }
        petDao.update(pet);
        System.out.println("Pet successfully updated. Returning to the options menu...");
        displayMenu();
        chooseOption();
    }

    public void addConsult() {
        Consult consult = new Consult();
        System.out.println("Here is a list of the pets for the consult:");
        System.out.println(petDao.getAllPets());
        System.out.print("Please select the pet for the consult by selecting de id: ");
        consult.setPet(petDao.findById(scanner.nextInt()));
        System.out.println("Here is a list of the veterinarians for the consult:");
        System.out.println(vetDao.getAllVeterinarians());
        System.out.print("Please select the veterinarian for the consult by selecting de id: ");
        consult.setVeterinarian(vetDao.findById(scanner.nextInt()));
        scanner.nextLine();
        System.out.print("Please enter date of the consult (yyyy-mm-dd): ");
        consult.setDate(Date.valueOf(scanner.nextLine()));
        System.out.print("Enter the description: ");
        consult.setDescription(scanner.nextLine());
        consultDao.addConsult(consult);
        System.out.println("Consult successfully added. Returning to the options menu...");
        displayMenu();
        chooseOption();
    }
}
