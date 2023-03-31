package com.codingChallenge.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("weather")
public class CityWeather {
    
    @Id
    private String id;

    private Location location ;
    private Weather weather;
    private Wind wind;
    private Sys sys;

    private String name;

    public CityWeather(){}

    public Location getCoord(){
        return this.location; 
    }

    public void setCoord(Location location){
        this.location = location;
    }

    public Weather getWeather(){
        return this.weather; 
    }

    public void setWeather(Weather weather){
        this.weather = weather;
    }

    public Wind getWind(){
        return this.wind; 
    }

    public void setWind(Wind wind){
        this.wind = wind;
    }

    public Sys getSys(){
        return this.sys; 
    }

    public void setSys(Sys sys){
        this.sys = sys;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

