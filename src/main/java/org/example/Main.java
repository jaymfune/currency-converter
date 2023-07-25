package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base currency, Available - ZAR, USD, EUR, CAD : ");
        String baseCurrency = input.nextLine().toUpperCase();

        System.out.print("Enter target currency, Available - ZAR, USD, EUR, CAD : ");
        String targetCurrency = input.nextLine().toUpperCase();

        System.out.print("Enter a value : ");
        int amount = input.nextInt();

        ExchangeRateApi currencyConverter = new ExchangeRateApi("Jqj2byx1Cy42Uyo1ZmRw1qMF2MvG5n8mmcSQDQ11");
        try {
            currencyConverter.convertCurrency(baseCurrency,
                    targetCurrency,
                    amount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}