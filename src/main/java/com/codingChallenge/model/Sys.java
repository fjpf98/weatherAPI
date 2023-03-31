package com.codingChallenge.model;

import java.util.Date;

public class Sys{

    private String country;
    private String sunRise;
    private String sunSet;

    public void Sys(){

    }

    public String getCountry( ){
        return this.country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getSunRise( ){
        return this.sunRise;
    }

    public void setSunRise(String sunRise){
        this.sunRise = sunRise;
    }

    public String getSunSet( ){
        return this.sunSet;
    }

    public void setSunSet(String sunSet){
        this.sunSet = sunSet;
    }

}