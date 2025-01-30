package com.example.mvcpetproject.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


@Data // Zur automatischen Erzeugung von Getter und Setter in .toString()
@NoArgsConstructor //Erstellt ein leeren Constructor
@AllArgsConstructor // Erstellt ein Constructor mit allen Eigenschaftsfeldern

public class Pet { // Unsere Pet Klasse
    private Long id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Type cannot be null")
    private String type;

    public Pet(long id, String name, String type){
        this.id=id;
        this.name=name;
        this.type=type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
