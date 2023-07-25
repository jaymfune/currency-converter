package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApi {
    private final String apiKey;
    private final String baseUrl;

    public ExchangeRateApi(String apiKey){
        this.apiKey = apiKey;
        this.baseUrl = "https://api.freecurrencyapi.com/";
    }

    // Method to get the exchange rate data for the provided base currency
    public JSONObject getExchangeRateData(String baseCurrency) throws IOException, InterruptedException {
        String endpoint = "v1/latest?";
        String query = String.format("apikey=%s&base_currency=%s", apiKey, baseCurrency);
        String apiUrl = baseUrl + endpoint + query;

        // Make an HTTP request to the API and get the response
        return makeHttpRequest(apiUrl); // Calls the method to make the HTTP request and parse the JSON response
    }

    // Method to make the HTTP request and parse the response as a JSON object
    JSONObject makeHttpRequest(String apiUrl) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        try {
            String exchangeRateData = response.body(); // Get the JSON response body

            // Parse the JSON response and get data
            return new JSONObject(exchangeRateData); // Convert the JSON string to a JSONObject
        } catch (Exception err){
            err.printStackTrace();

            // Throw an error if there is an issue parsing the JSON response
            throw new IOException("Failed to parse JSON response.", err);
        }
    }

    // Method to convert currency and print the result
    public void convertCurrency(String baseCurrency, String conversionCurrency, double amount) throws IOException, InterruptedException {
        JSONObject response;
        response = getExchangeRateData(baseCurrency); // Get the exchange rate data for the base currency

        double targetedCurrency = response.getJSONObject("data").getDouble(conversionCurrency); // Get the exchange rate for the target currency

        double convertedAmount = Math.round((amount * targetedCurrency) * 100.0) / 100.0; // Perform the currency conversion
        System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + conversionCurrency); // Print the converted amount
    }
}
