package com.codingChallenge.weatherAPI;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codingChallenge.model.CityWeather;

public interface WeatherRepository extends MongoRepository<CityWeather, String>{
    
}