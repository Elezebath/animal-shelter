package org.example.model;

public final class Lion extends Animal {
    public Lion(AnimalId id, String name, int age){
        super(id,name,age);
    }

    @Override
    public String getSpecies(){
        return "Lion";
    }
}
