/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;

/**
 *
 * @author Everson
 */
public class Temperature implements Serializable{
    
    private double value, min, max;
    private String unit;

    public Temperature(double value, double min, double max, String unit) {
        this.value = value;
        this.min = min;
        this.max = max;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Temperature{" + "value=" + value + ", min=" + min + ", max=" + max + ", unit=" + unit + '}';
    }

}
