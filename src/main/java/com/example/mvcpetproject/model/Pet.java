package com.example.mvcpetproject.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;



@Entity // Сущность = Джава класс, который отображается в таблице БД. Каждая сущность = обьект в соответствующей строке.
public class Pet {
    @Id // key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id wird automatisch generiert
    private Long id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Type cannot be null")
    private String type;

    private int age;


    public Pet(){}
    public Pet(long id, String name, String type,int age){
        this.id=id;
        this.name=name;
        this.type=type;
        this.age=age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
