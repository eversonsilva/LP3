/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.marvel;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author cacique
 */
public class MarvelCharacterJSONParser {
    
    public static List<MarvelCharacter> parseFeed(String content){
        List<MarvelCharacter> personagens = new ArrayList<>();
        
        JsonReader jsonReader = Json.createReader(new StringReader(content));
        JsonObject obj = jsonReader.readObject();
        jsonReader.close();
        
        JsonObject data = obj.getJsonObject("data");
        JsonArray results = data.getJsonArray("results");
        
        for (int i = 0; i < results.size(); i++) {
            JsonObject p = results.getJsonObject(i);
            
            int id = p.getInt("id");
            String name = p.getString("name");
            String desc = p.getString("description");
            
            JsonObject thumb = p.getJsonObject("thumbnail");
            String thumbnail = thumb.getString("path") + "." + thumb.getString("extension");
            
            MarvelCharacter mc = new MarvelCharacter(id, name, desc, thumbnail);
            personagens.add(mc);
        }
        
        return personagens;
    }
    
}
