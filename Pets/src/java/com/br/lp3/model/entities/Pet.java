/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

/**
 *
 * @author Everson
 */
public class Pet {

    private String name, photo, description, race, city;
    private Integer age;
    private State state;
    private Country country;

    public Pet() {

    }

    public Pet(String name, String photo, String description, String race, String city, Integer age, State state, Country country) {
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.race = race;
        this.city = city;
        this.age = age;
        this.state = state;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Pet{" + "name=" + name + ", photo=" + photo + ", description=" + description + ", race=" + race + ", city=" + city + ", age=" + age + ", state=" + state + ", country=" + country + '}';
    }

}
