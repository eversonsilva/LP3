/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.webservice;

import com.br.lp3.webservice.entities.Estado;
import com.br.lp3.webservice.entities.Pais;
import com.br.lp3.webservice.entities.Pet;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Everson
 */
public class PetJSONParser {
    
    public static List<Pet> parseFeed(String content){
        List<Pet> resposta = new ArrayList<>();
        
        JsonReader reader = Json.createReader(new StringReader(content));
        JsonObject raiz = reader.readObject();
        reader.close();
        
        int success = raiz.getInt("success");
        if(success == 1){
            
            JsonArray pets  = raiz.getJsonArray("pets");
            for (int i = 0; i < pets.size(); i++) {
                
                JsonObject obj = pets.getJsonObject(i);
                
                String name = obj.getString("name");
                String photo = obj.getString("photo");
                String description = obj.getString("description");
                int age = Integer.parseInt(obj.getString("age"));
                String race = obj.getString("race");
                String city = obj.getString("city");
                
                    JsonObject state = obj.getJsonObject("state");
                    String stateName = state.getString("name");
                    String stateInitials = state.getString("initials");
                    
                    Estado estado = new Estado(stateName, stateInitials);
                    
                    JsonObject country = obj.getJsonObject("country");
                    String countryName = country.getString("name");
                    String countryInitials = country.getString("initials");
                    
                    Pais pais = new Pais(countryName, countryInitials);
                    
                Pet pet = new Pet(name, photo, description, race, city, age, estado, pais);
                    
                resposta.add(pet);
            }
    
            
        }else{
            System.out.println("Não encontrou nenhum pet na API");
        }
        
        return resposta;
    }
    
}
