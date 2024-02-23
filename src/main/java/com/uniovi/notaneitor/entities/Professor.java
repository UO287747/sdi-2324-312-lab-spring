package com.uniovi.notaneitor.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {
    @Id
    @GeneratedValue
    private Long id;
    private String dni;
    private String name;
    private String surname;
    private String category;

    public Professor(String dni, String name, String surname, String category) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.category = category;
    }

    public Professor() {
    }

    public Long getId() {
        return id;
    }
    public String getDni() {
        return dni;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "DNI='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}