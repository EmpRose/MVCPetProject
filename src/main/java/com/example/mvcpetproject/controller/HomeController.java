package com.example.mvcpetproject.controller;

import com.example.mvcpetproject.model.Pet;
import com.example.mvcpetproject.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class HomeController {
    private final PetService petService;
    public HomeController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping // Zum Verarbeiten von HTTP offer
    public String home(){
        return  "It works!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.getPetById(id);
        return pet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
