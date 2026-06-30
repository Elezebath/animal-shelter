package org.example.shelter;

import org.example.model.AdoptionStatus;
import org.example.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class Shelter <T extends Animal>{
    private final List<T> animals = new ArrayList<>();

    public void addAnimal(T animal){
        animals.add(animal);
    }

    /**
     * Get all animals in the shelter
     * @return a new List of animals in shelter
     */
    public List<T> getAllAnimals(){
        return new ArrayList<>(animals);
    }

    /**
     * Return the animal with requested species
     * @param species species to be searched
     * @return a new List of animals in shelter with specified species
     */
    public List<T> findBySpecies(String species){
        List<T> result = new ArrayList<>();
        species = species.toLowerCase();

        for(T animal: animals) {
            if(animal.getSpecies().toLowerCase().equals(species)) {
                result.add(animal);
            }
        }
        return result;
    }

    /**
     * @return a new List of animals in shelter with adoption status as available
     */
    public List<T> findAvailableAnimals(){
        List<T> result = new ArrayList<>();

        for(T animal: animals) {
            if(animal.getAdoptionStatus().equals(AdoptionStatus.AVAILABLE)) {
                result.add(animal);
            }
        }
        return result;
    }

    /**
     * Marks the animal with the specified ID as adopted.
     *
     * @param id the ID of the animal to mark as adopted
     */
    public void markAsAdopted(String id){
        boolean foundAnimal = false;
        for(T animal: animals) {
            if(animal.getId().toString().equals(id)) {
                foundAnimal = true;
                animal.markAsAdopted();
                break;
            }
        }
        if(!foundAnimal) System.out.println("No animal found with the given ID.");
    }
}
