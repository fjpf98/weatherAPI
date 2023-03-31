package com.codingChallenge.weatherAPI;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingChallenge.model.CityWeather;

import okhttp3.Response;

@SpringBootApplication
@RestController
public class WeatherApiApplication{

	@Autowired
	private WeatherService wService;

	@GetMapping("/weather")
	public void GetCityWeather(@RequestParam String city){
		try {
			
			Boolean saved = this.wService.save(wService.GetCityWeather(city));

			if(saved){
				System.out.println("Weather from " + city + " saved in mongoDB");
			}else{
				System.out.println("Weather from " + city + " not saved in mongoDB");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println("starting ...");
 		SpringApplication.run(WeatherApiApplication.class, args);
		System.out.println("Started!");
	}

}
