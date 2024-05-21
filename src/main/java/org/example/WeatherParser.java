package org.example;

import org.json.JSONObject;

public class WeatherParser {

    public void printWeatherData(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONObject location = jsonObject.getJSONObject("location");
        JSONObject current = jsonObject.getJSONObject("current");

        String cityName = location.getString("name");
        String region = location.getString("region");
        String country = location.getString("country");
        String localtime = location.getString("localtime");

        double tempCelsius = current.getDouble("temp_c");
        double feelsLikeCelsius = current.getDouble("feelslike_c");
        int humidity = current.getInt("humidity");
        double windKph = current.getDouble("wind_kph");
        String windDir = current.getString("wind_dir");
        double pressureMb = current.getDouble("pressure_mb");
        double precipMm = current.getDouble("precip_mm");
        String conditionText = current.getJSONObject("condition").getString("text");

        System.out.println("Погодні дані для " + cityName + ", " + region + ", " + country);
        System.out.println("Місцевий час: " + localtime);
        System.out.println("Температура: " + tempCelsius + "°C");
        System.out.println("Відчувається як: " + feelsLikeCelsius + "°C");
        System.out.println("Погодні умови: " + conditionText);
        System.out.println("Вологість: " + humidity + "%");
        System.out.println("Вітер: " + windKph + " км/год " + windDir);
        System.out.println("Тиск: " + pressureMb + " мбар");
        System.out.println("Опади: " + precipMm + " мм");
    }
}
