package com.example.mvcpetproject.controller;
import com.example.mvcpetproject.model.Pet;
import com.example.mvcpetproject.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController { // Controller der mit PetService arbeitet

    private final PetService petService;

    public PetController(PetService petService){
        this.petService = petService;
    }

    @GetMapping // Gibt die Liste aller Pets zurück
    public List<Pet> getAllPets(){
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id){
        Optional<Pet> pet = petService.getPetById(id);
        return pet.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PostMapping // Nimmt ein JSON Object um einen Pet derListe hinzuzufügen
    public ResponseEntity<String> addPet(@RequestBody @Valid Pet pet){ // ResponseEntity als Visuele Rückgabe
        petService.addPet(pet);
        return ResponseEntity.ok("Pet added successfully."); // Rückgabe des erstellten Pets mit Code
    }

    @PutMapping("/{id}")  // Обновление питомца по ID
    public ResponseEntity<String> updatePet(@PathVariable Long id, @RequestBody @Valid Pet pet) {
        pet.setId(id);  // Устанавливаем id для переданного объекта
        petService.updatePet(pet);  // Обновляем питомца через сервис
        return ResponseEntity.ok("Pet updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetById(@PathVariable Long id){
        boolean isRemoved = petService.removePetById(id);
        if (isRemoved){
            return ResponseEntity.noContent().build(); // 204 No Contenct (Wenn Löschung erfolgreich)
        }else{
            return ResponseEntity.notFound().build(); // 404 Not Found (Wenn die ID nicht gefunden wurde)
        }
    }


}
