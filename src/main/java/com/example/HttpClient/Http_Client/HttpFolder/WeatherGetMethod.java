package com.example.HttpClient.Http_Client.HttpFolder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class WeatherGetMethod {
    private static final String URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
    private static final String KEY = "13cd9f123d81a259ff3f513b9ca55294";


    public static JSONObject weather(String location) {
        HttpClient client = HttpClient.newHttpClient();
        String url = String.format(URL, location, KEY);

        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url))
                .GET().build();

        try{
            HttpResponse<String> response = client.send(httpRequest,HttpResponse.BodyHandlers.ofString());
          //  System.out.println("Response body is: "+response.body());
            System.out.println("Response status is: " + response.statusCode());

            JSONObject obj = new JSONObject(response.body());
            System.out.println("Temperature in Kalvin is: " + obj.getJSONObject("main").getDouble("temp"));
            double kalvin = obj.getJSONObject("main").getDouble("temp");
            double celsius = kalvin - 273.15;
            System.out.println("Temperature : " + celsius + " °C");
            System.out.println("Humidity " + obj.getJSONObject("main").getInt("humidity"));

            JSONArray weather = obj.getJSONArray("weather");
            for (int i = 0; i < weather.length(); i++) {
                JSONObject newWeather = weather.getJSONObject(i);
                String weatherSituation = newWeather.getString("main");
                    System.out.println("It is " + weatherSituation);

            }
            return obj;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the location of your weather to be searched: ");
        String location = scanner.nextLine();
      weather(location);

    }
}
