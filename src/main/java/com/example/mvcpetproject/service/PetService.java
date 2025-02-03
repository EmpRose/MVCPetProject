package com.example.mvcpetproject.service;
import com.example.mvcpetproject.model.Pet;
import com.example.mvcpetproject.repository.PetRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService { // Service zur Datenkontrolle (Wie TaskManager für Tasks)
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public Pet createPet(Pet pet){
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets(){

        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Long id) {

        return petRepository.findById(id);
    }

    public void addPet (Pet pet){
        petRepository.save(pet);
    }

    public Pet updatePet(Long id, Pet petDetails) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
        pet.setName(petDetails.getName());
        pet.setType(petDetails.getType());
        pet.setAge(petDetails.getAge());
        return petRepository.save(pet);
}
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
