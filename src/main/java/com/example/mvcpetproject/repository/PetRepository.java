package com.example.mvcpetproject.repository;

import com.example.mvcpetproject.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
    // Ein JPA Repository für die Arbeit mit Pet Entity
    // Erlaubt es CRUD Methoden auszuführen

}
