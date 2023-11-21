package com.coderscratchpad.javafxtutorial.rest;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-and-restful-web-services-integration/">coderscratchpad.com</a>
 */
public class PostClient {

    private static final String API_URL = "https://jsonplaceholder.typicode.com/posts";

    public static Post[] getAll() throws IOException {

        HttpURLConnection connection = null;

        try {

            // Create a URL object and open a connection
            URL url = new URL(API_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the HTTP response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                // Use Gson to deserialize the JSON response into an array of Post objects
                Gson gson = new Gson();
                return gson.fromJson(parseResponse(connection), Post[].class);
            } else {

                // Handle API request failure with an exception
                throw new IOException("API request failed with response code: " + responseCode);
            }

        } finally {

            if (connection != null) {

                connection.disconnect();
            }

        }
    }

    private static String parseResponse(HttpURLConnection connection) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            // Read the response content line by line
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();

        }
    }
}