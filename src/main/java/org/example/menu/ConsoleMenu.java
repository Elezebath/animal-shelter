package org.example.menu;

import org.example.model.*;
import org.example.shelter.Shelter;
import org.example.validator.AnimalInputValidator;

import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private final Shelter<Animal> shelter;
    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }

    public void start(){
        while(true) {
            printMenu();

            System.out.print("Select your option: ");
            int choice = AnimalInputValidator.getValidInt(scanner,"Menu option");

            switch(choice) {
                case 1 :
                    addAnimalToShelter();
                    break;
                case 2 :
                    List<Animal> animals = shelter.getAllAnimals();
                    printAnimalList(animals, "No animals found.");
                    break;
                case 3 :
                    System.out.print("Enter the species: ");
                    String species = AnimalInputValidator.getValidString(scanner,"Species");
                    List<Animal> result = shelter.findBySpecies(species);
                    printAnimalList(result, "No animals found for the specified species.");
                    break;
                case 4 :
                    List<Animal> availableAnimals = shelter.findAvailableAnimals();
                    printAnimalList(availableAnimals, "No animals are currently available for adoption.");
                    break;
                case 5 :
                    System.out.print("Enter ID of the animal: ");
                    shelter.markAsAdopted (AnimalInputValidator.getValidString(scanner,"ID"));
                    break;
                case 0:
                    System.out.println("===========END=========");
                    return;
                default:
                    System.out.println("Invalid menu option. Please select a valid option.");
                    break;

            }
            System.out.println();

        }
    }


    /**
     *
     * @param animals list of animals
     * @param emptyMessage message to be printed in case of empty list
     */
    private void printAnimalList(List<Animal> animals, String emptyMessage) {

        if(animals.isEmpty()) {
            System.out.println(emptyMessage != null ? emptyMessage : "No animals found!!!");
        }
        else {
            for( Animal animal: animals ) System.out.println(animal);
        }
    }

    /**
     * Get animal information and update the shelter with new animal
     */
    private void addAnimalToShelter() {
        // get animal information
        System.out.println("Enter the following information: ");
        System.out.println("Species: ");
        String species = AnimalInputValidator.getValidString(scanner,"Species");

        System.out.println("Name: ");
        String name = AnimalInputValidator.getValidString(scanner,"Name");

        System.out.println("Age: ");
        int age = AnimalInputValidator.getValidInt(scanner,"Age");
        Animal animal;

        switch (species) {
            case "dog" -> animal = new Dog(new AnimalId(), name, age);
            case "cat" -> animal = new Cat(new AnimalId(), name, age);
            case "bird" -> animal = new Bird(new AnimalId(), name, age);
            default -> {
                System.out.println("Unknown species.");
                return;
            }
        }
        shelter.addAnimal(animal);
        System.out.println(name + " [" + species +  "] added to the shelter successfully");
    }

    private void printMenu(){
        System.out.println("""
                1. Add animal
                2. List all animals
                3. Find animals by species
                4. List available animals
                5. Mark animal as adopted
                0. Exit
                """);
    }
}
