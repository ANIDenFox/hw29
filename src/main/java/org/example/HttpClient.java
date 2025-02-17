package org.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    private static final String API_KEY = "ea24b97589mshdaf1b5763f0c93bp187402jsnb76cdd9e47d2";
    private static final String BASE_URL = "https://weatherapi-com.p.rapidapi.com/current.json";

    public String getWeatherData(String location) throws Exception {
        String urlString = BASE_URL + "?q=" + location;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("x-rapidapi-host", "weatherapi-com.p.rapidapi.com");
        connection.setRequestProperty("x-rapidapi-key", API_KEY);

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        } else {
            throw new Exception("GET request failed: " + responseCode);
        }
    }
}