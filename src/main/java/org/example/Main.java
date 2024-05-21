package org.example;

public class Main {
    public static void main(String[] args) {
        String location = "London";
        HttpClient httpClient = new HttpClient();
        WeatherParser weatherParser = new WeatherParser();

        try {
            String jsonResponse = httpClient.getWeatherData(location);
            weatherParser.printWeatherData(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}