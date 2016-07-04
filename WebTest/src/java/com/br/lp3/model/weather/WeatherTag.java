/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.weather;

import com.br.lp3.model.entities.Temperature;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Everson
 */
public class WeatherTag extends SimpleTagSupport {

    private String city;

    public void setCity(String city) {
        this.city = city;
    }

    private String units;

    public void setUnits(String units) {
        this.units = units;
    }

    private String appid;

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Override
    public void doTag() throws JspException, IOException {
        String uri = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&mode=xml&units=" + units + "&appid=" + appid;

        XMLParser xmlp = new XMLParser();
        xmlp.openURL(uri);
        Temperature t = xmlp.parseCurrentWeather();
        
        JspWriter out = getJspContext().getOut();
        
        out.print("<div>"
                    + "<h1>"+city+"</h1>" 
                    + "<h3>"+t.getValue()+"</h3>"
                + "</div>");
        
    }

}
