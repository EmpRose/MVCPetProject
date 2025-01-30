package com.example.mvcpetproject.service;
import com.example.mvcpetproject.model.Pet;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService { // Service zur Datenkontrolle (Wie TaskManager für Tasks)
    private final List<Pet> pets = new ArrayList<>();

    public PetService(){ // Der Constructor erstellt direkt eine Liste von Pets
        pets.add(new Pet(1L, "Buddy","Dog"));
        pets.add(new Pet(2L, "Mittens","Cat"));
    }

    //Alle Pets zurückgeben
    public List<Pet> getAllPets(){
        return pets;
    }

    // Einen Pet via ID zurückgeben
    public Optional<Pet> getPetById(Long id) {

        return pets.stream() // Stream zum Suchen nutzen
                .filter(pet -> pet.getId().equals(id)) // Nach ID filtern
                .findFirst(); // Das erst gefundene Element wird zurückgegeben.
    }

    // Einen Pet zur Liste hinzufügen
    public void addPet (Pet pet){
        pets.add(pet);
    }

    public void updatePet(Pet updatedPet){
        for (int i = 0; i < pets.size(); i++){
            Pet existingPet = pets.get(i);
            if (existingPet.getId().equals(updatedPet.getId())){
                pets.set(i,updatedPet); // Ersetzen des Pets, wenn die selbe ID eingegeben wurde
                return;
            }
        }
    }

    public boolean removePetById(Long id){
        return pets.removeIf(pet -> pet.getId().equals(id));
    }
}
