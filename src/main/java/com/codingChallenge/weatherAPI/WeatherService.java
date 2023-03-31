package com.codingChallenge.weatherAPI;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingChallenge.model.CityWeather;
import com.codingChallenge.model.Location;
import com.codingChallenge.model.Sys;
import com.codingChallenge.model.Weather;
import com.codingChallenge.model.Wind;
import com.eclipsesource.json.Json;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository wRepository;

    public CityWeather save(Response res) throws IOException {
        // gets weather information
        com.eclipsesource.json.JsonObject weatherInfo = Json.parse(res.body().string()).asObject();

        // parses response

        // gets the city location
        com.eclipsesource.json.JsonObject coords = Json.parse(weatherInfo.get("coord").toString()).asObject();

        Float lon = coords.get("lon").asFloat();
        Float lat = coords.get("lat").asFloat();
        Location cityCoords = new Location();
        cityCoords.setLat(lat);
        cityCoords.setLonge(lon);

        // gets temperature
        com.eclipsesource.json.JsonObject temp = Json.parse(weatherInfo.get("main").toString()).asObject();

        Float temperature = temp.get("temp").asFloat();
        Float feelsLike = temp.get("feels_like").asFloat();
        Float temp_min = temp.get("temp_min").asFloat();
        Float temp_max = temp.get("temp_max").asFloat();
        Integer pressure = temp.get("pressure").asInt();
        Integer humidity = temp.get("humidity").asInt();

        Weather weather = new Weather();
        weather.setFeelsLike(feelsLike);
        weather.setHumidity(humidity);
        weather.setPressure(pressure);
        weather.setTemp(temperature);
        weather.setTemp_max(temp_max);
        weather.setTemp_min(temp_min);

        // Gets wind information
        com.eclipsesource.json.JsonObject windInfo = Json.parse(weatherInfo.get("wind").toString()).asObject();

        Float wind_speed = windInfo.get("speed").asFloat();
        Integer wind_deg = windInfo.get("deg").asInt();

        Wind wind = new Wind();
        wind.setSpeed(wind_speed);
        wind.setDeg(wind_deg);

        // Gets sys information
        com.eclipsesource.json.JsonObject sysInfo = Json.parse(weatherInfo.get("sys").toString()).asObject();

        String country = sysInfo.get("country").asString();
        Date sunRise = new Date(sysInfo.get("sunrise").asLong() * 1000L );
        Date sunSet = new Date(sysInfo.get("sunset").asLong() * 1000L );

        Sys sys = new Sys();        
        SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        sys.setCountry(country);
        sys.setSunRise(jdf.format(sunRise));
        sys.setSunSet(jdf.format(sunSet));

        CityWeather c = new CityWeather();
        c.setCoord(cityCoords);
        c.setName(Json.parse(weatherInfo.get("name").toString()).asString());
        c.setWeather(weather);
        c.setWind(wind);
        c.setSys(sys);

        return this.wRepository.save(c);
    }


    public Response GetCityWeather(String city) throws IOException {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://open-weather13.p.rapidapi.com/city/" + city)
				.get()
				.addHeader("X-RapidAPI-Key", "f0a8c3392fmsh22c083af9c95bd3p1b18d0jsnb196fff68295")
				.addHeader("X-RapidAPI-Host", "open-weather13.p.rapidapi.com")
				.build();

		Response response = client.newCall(request).execute();
		return response;
	}
}
