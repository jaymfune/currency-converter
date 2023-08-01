package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExchangeRateApi currencyConverter = new ExchangeRateApi("Jqj2byx1Cy42Uyo1ZmRw1qMF2MvG5n8mmcSQDQ11");
        Scanner input = new Scanner(System.in);

        ExchangeRateUI exchangeRateUI = new ExchangeRateUI(currencyConverter, input);
        exchangeRateUI.startProgram();
    }
}