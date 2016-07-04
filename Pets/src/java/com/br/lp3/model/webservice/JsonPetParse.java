/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.webservice;


import com.br.lp3.model.entities.Country;
import com.br.lp3.model.entities.Pet;
import com.br.lp3.model.entities.State;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author thiago
 */
public class JsonPetParse {
    
    public static List<Pet> parseFeed (String content){
        
        
        JsonReader reader = Json.createReader(new StringReader(content));
        JsonObject raiz = reader.readObject();
        reader.close();
        
        List<Pet> pets = new ArrayList();
        JsonArray petsArray = raiz.getJsonArray("pets");
        
        for(int i = 0; i < petsArray.size(); i++){
            JsonObject obj = petsArray.getJsonObject(i);
            
            // Estado
            JsonObject stateJson = obj.getJsonObject("state");
            String nameState = stateJson.getString("name");
            String initialsState = stateJson.getString("initials");
            State state = new State(nameState,initialsState);
            
            // Pais
            JsonObject countryJson = obj.getJsonObject("country");
            String nameCountry = countryJson.getString("name");
            String initialsCountry = countryJson.getString("initials");
            Country country = new Country(nameCountry,initialsCountry);
            
            // Pet
            String namePet = obj.getString("name");
            String photoPet = obj.getString("photo");
            String descriptionPet = obj.getString("description");
            Integer agePet = Integer.parseInt(obj.getString("age"));
            String racePet = obj.getString("race");
            String cityPet = obj.getString("city");
            Pet pet = new Pet(namePet, photoPet, descriptionPet, racePet, cityPet, agePet, state, country);
            pets.add(pet);
        }
        return pets;
    }
}
