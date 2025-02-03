package com.example.mvcpetproject.controller;
import com.example.mvcpetproject.model.Pet;
import com.example.mvcpetproject.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;
    @PostMapping
    public Pet createPet(@RequestBody Pet pet){
        return petService.createPet(pet);
    }

    @GetMapping
    public List<Pet> getAllPets(){
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Optional<Pet> getPetById(@PathVariable Long id){
        return petService.getPetById(id);
    }

    @PutMapping("/{id}")  // Обновление питомца по ID
    public Pet updatePet(@PathVariable Long id, @RequestBody @Valid Pet petDetails) {
        return petService.updatePet(id,petDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePetById(@PathVariable Long id){
        petService.deletePet(id);
    }


}
