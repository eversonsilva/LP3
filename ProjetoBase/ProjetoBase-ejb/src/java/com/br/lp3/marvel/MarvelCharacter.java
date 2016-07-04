/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.marvel;

import java.io.Serializable;

/**
 *
 * @author cacique
 */
public class MarvelCharacter implements Serializable{
    
    private int id;
    private String name;
    private String description;
    private String thumbnail;

    public MarvelCharacter() {
    }

    public MarvelCharacter(int id, String name, String description, String thumbnail) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "MarvelCharacter{" + "id=" + id + ", name=" + name + ", description=" + description + ", thumbnail=" + thumbnail + '}';
    }
    
}
