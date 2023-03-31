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

@SpringBootApplication
@RestController
public class WeatherApiApplication{

	@Autowired
	private WeatherService wService = new WeatherService();

	@GetMapping("/weather")
	public boolean GetCityWeather(@RequestParam String city){
		CityWeather weatherSaved = null;
		boolean success = false;
		try {
			weatherSaved = this.wService.save(wService.GetCityWeather(city));
			if(weatherSaved != null){
				success= true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(weatherSaved == null){
			success = false;
		}
		return success;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("starting ...");
 		SpringApplication.run(WeatherApiApplication.class, args);
		System.out.println("Started!");
	}

}
