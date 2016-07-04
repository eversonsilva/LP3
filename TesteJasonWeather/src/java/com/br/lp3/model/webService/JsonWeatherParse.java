/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.webService;

import com.br.lp3.model.entities.Weather;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Everson
 */
public class JsonWeatherParse {
 
    public static Weather parseFeed(String content){
        Weather w = null;
        
        JsonReader reader = Json.createReader(new StringReader(content));
        JsonObject raiz = reader.readObject();
        reader.close();
        
        JsonObject mainobj = raiz.getJsonObject("main");
        double temp = Double.parseDouble(mainobj.getJsonNumber("temp").toString());
        double pressure = Double.parseDouble(mainobj.getJsonNumber("pressure").toString());
        double humidity = Double.parseDouble(mainobj.getJsonNumber("humidity").toString());
        double temp_min = Double.parseDouble(mainobj.getJsonNumber("temp_min").toString());
        double temp_max = Double.parseDouble(mainobj.getJsonNumber("temp_max").toString());
        
        w = new Weather(temp, pressure, humidity, temp_min, temp_max);
        
        JsonArray weather = raiz.getJsonArray("weather");
        
        for (int i = 0; i < weather.size(); i++) {
            JsonObject obj = weather.getJsonObject(i);
            System.out.println(obj.getInt("id"));
        }
        
        return w;
    }
    
}
