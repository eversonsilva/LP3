/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.webservice;

import com.br.lp3.model.entities.Map;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;



/**
 *
 * @author Everson
 */
public class JsonMapParse {
    
    public static Map parseFeed(String content){
        Map m = null;
        
        JsonReader reader = Json.createReader(new StringReader(content));
        JsonObject raiz = reader.readObject();
        reader.close();
        
        JsonObject mainobj = raiz.getJsonObject("main");
        double lat = Double.parseDouble(mainobj.getJsonNumber("pressure").toString());
        double lon = Double.parseDouble(mainobj.getJsonNumber("humidity").toString());
        
        m = new Map(lat, lon);
        
        JsonArray maps = raiz.getJsonArray("map");
        
        for (int i = 0; i < maps.size(); i++) {
            JsonObject obj = maps.getJsonObject(i);
            System.out.println(obj.getInt("id"));
        }
        
        return m;
    }
    
}
