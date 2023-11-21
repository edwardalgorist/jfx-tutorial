package com.coderscratchpad.javafxtutorial.currencyconverter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/building-a-real-time-currency-converter-in-javafx/">coderscratchpad.com</a>
 */
public class ExchangeRatesClient {

    private static final String API_BASE_URL = "http://api.exchangerate.host";
    private static final String API_ACCESS_KEY = "XXXXXXXXXXXXXXXXXXXXXXXXXX";

    /**
     * Convert an amount from one currency to another.
     *
     * @param from   The source currency code.
     * @param to     The target currency code.
     * @param amount The amount to convert.
     * @return An array containing the exchange rate and the converted result.
     * @throws IOException If an error occurs while making the API request.
     */
    public static double[] convert(String from, String to, double amount) throws IOException {

        // Create the query string with parameters
        String query = String.format("?from=%s&to=%s&amount=%.2f", from, to, amount);

        // Make an API request to convert the amount and parse the JSON response
        JsonObject json = apiRequest("/convert" + query);

        JsonElement rateElement = json.getAsJsonObject("info").get("quote");
        JsonElement resultElement = json.get("result");

        // Extract the exchange rate and result from the JSON
        double rate = rateElement.isJsonNull() ? 0.0: rateElement.getAsDouble();
        double result = resultElement.isJsonNull() ? 0.0: resultElement.getAsDouble();

        return new double[]{rate, result};

    }

    /**
     * Make an API request to retrieve exchange rate information.
     *
     * @param path The API endpoint path with parameters.
     * @return The JSON response from the API as a JsonObject.
     * @throws IOException If an error occurs while making the API request.
     */
    private static JsonObject apiRequest(String path) throws IOException {

        HttpURLConnection connection = null;

        try {

            // Build the URL with the API base URL and path
            URL url = new URL(API_BASE_URL + path + "&access_key=" + API_ACCESS_KEY);

            // Open an HTTP connection
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the HTTP response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                // Parse and return the JSON response as a JsonObject
                return new Gson().fromJson(parseResponse(connection), JsonObject.class);
            } else {
                throw new IOException("API request failed with response code: " + responseCode);
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * Parse the response from an HTTP connection into a string.
     *
     * @param connection The HTTP connection.
     * @return The response content as a string.
     * @throws IOException If an error occurs while reading the response.
     */
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