package org.example;

import java.io.IOException;
import java.util.Scanner;

public class ExchangeRateUI {
    private final ExchangeRateApi exchangeRateApi;
    private final Scanner input;

    // Dependency injection : constructor injection
    public ExchangeRateUI(ExchangeRateApi exchangeRateApi, Scanner input) {
        this.exchangeRateApi = exchangeRateApi;
        this.input = input;
    }

    public void startProgram() {
        String baseCurrency;
        String targetCurrency;

        // Validate base currency input
        do {
            System.out.print("Enter base currency, Available - ZAR, USD, EUR, CAD : ");
            baseCurrency = input.nextLine().toUpperCase();
        } while (!isValidCurrency(baseCurrency));

        // Validate target currency input
        do {
            System.out.print("Enter target currency, Available - ZAR, USD, EUR, CAD : ");
            targetCurrency = input.nextLine().toUpperCase();
        } while (!isValidCurrency(targetCurrency));

        System.out.print("Enter a value : ");

        // Validate input from user
        while (!input.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid integer.");
            System.out.print("Enter a value : ");
            input.next();
        }

        int amount = input.nextInt();

        ExchangeRateApi currencyConverter = new ExchangeRateApi("Jqj2byx1Cy42Uyo1ZmRw1qMF2MvG5n8mmcSQDQ11");

        try {
            currencyConverter.convertCurrency(baseCurrency, targetCurrency, amount);
        } catch (IOException e) {
            // Error message for input/output operations.
            System.err.println("An error occurred while fetching the exchange rate data. Please try again later.");
        } catch (InterruptedException e) {
            // Error message for interruption in the conversion process.
            System.err.println("The currency conversion process was interrupted. Please try again later.");
        }

        input.close();
    }

    // Method to validate the currency code
    private static boolean isValidCurrency(String currency) {
        // Use regex pattern to match input
        return currency.matches("^(ZAR|USD|EUR|CAD)$");
    }
}
