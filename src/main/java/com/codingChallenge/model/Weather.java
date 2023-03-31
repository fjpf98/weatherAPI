package com.codingChallenge.model;


public class Weather{

    private Float temp;
    private Float feelsLike;
    private Float temp_min;
    private Float temp_max;
    private Integer pressure;
    private Integer humidity;

    private Integer visibility;


    public void Weather(){

    }

    public Float getTempo(){
        return this.temp;
    }

    public void setTemp(Float temp){
        this.temp = temp;
    }
    
    public Float getFeelsLike(){
        return this.feelsLike;
    }

    public void setFeelsLike(Float feelsLike){
        this.feelsLike = feelsLike;
    }

    public Float getTemp_min(){
        return this.temp_min;
    }

    public void setTemp_min(Float temp_min){
        this.temp_min = temp_min;
    }

    public Float getTemp_max(){
        return this.temp_max;
    }

    public void setTemp_max(Float temp_max){
        this.temp_max = temp_max;
    }

    public Integer getPressure(){
        return this.pressure;
    }

    public void setPressure(Integer pressure){
        this.pressure = pressure;
    }

    public Integer getHumidity(){
        return this.humidity;
    }

    public void setHumidity(Integer humidity){
        this.humidity = humidity;
    }

    public Integer getVisibility(){
        return this.visibility;
    }

    public void setVisibility(Integer visibility){
        this.visibility = visibility;
    }

}