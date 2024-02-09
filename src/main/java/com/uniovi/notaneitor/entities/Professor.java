package com.uniovi.notaneitor.entities;

public class Professor {

    private Long id;
    private String DNI;
    private String name;
    private String surname;
    private String category;

    public Professor(){}

    public Professor(String DNI, String name, String surname, String category) {
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.category = category;
    }

    public Long getId() {
        return id;
    }
    public String getDNI() {
        return DNI;
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
    public void setDNI(String DNI) {
        this.DNI = DNI;
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
                "DNI='" + DNI + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
