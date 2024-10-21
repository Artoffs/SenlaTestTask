package convertcurr;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Курсы обмена относительно доллара США
        final double USD_TO_EUR = 0.85;
        final double USD_TO_GBP = 0.75;
        final double USD_TO_JPY = 110.0;
        final double USD_TO_CNY = 6.4;

        // Пересчитаем курсы для всех валют относительно друг друга
        final double EUR_TO_USD = 1 / USD_TO_EUR;
        final double EUR_TO_GBP = EUR_TO_USD * USD_TO_GBP;
        final double EUR_TO_JPY = EUR_TO_USD * USD_TO_JPY;
        final double EUR_TO_CNY = EUR_TO_USD * USD_TO_CNY;

        final double GBP_TO_USD = 1 / USD_TO_GBP;
        final double GBP_TO_EUR = GBP_TO_USD * USD_TO_EUR;
        final double GBP_TO_JPY = GBP_TO_USD * USD_TO_JPY;
        final double GBP_TO_CNY = GBP_TO_USD * USD_TO_CNY;

        final double JPY_TO_USD = 1 / USD_TO_JPY;
        final double JPY_TO_EUR = JPY_TO_USD * USD_TO_EUR;
        final double JPY_TO_GBP = JPY_TO_USD * USD_TO_GBP;
        final double JPY_TO_CNY = JPY_TO_USD * USD_TO_CNY;

        final double CNY_TO_USD = 1 / USD_TO_CNY;
        final double CNY_TO_EUR = CNY_TO_USD * USD_TO_EUR;
        final double CNY_TO_GBP = CNY_TO_USD * USD_TO_GBP;
        final double CNY_TO_JPY = CNY_TO_USD * USD_TO_JPY;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму и валюту (USD, EUR, GBP, JPY, CNY): ");
        double amount = scanner.nextDouble();
        String currency = scanner.next().toUpperCase();

        switch (currency) {
            case "USD":
                convert(amount, "USD", USD_TO_EUR, USD_TO_GBP, USD_TO_JPY, USD_TO_CNY);
                break;
            case "EUR":
                convert(amount, "EUR", EUR_TO_USD, EUR_TO_GBP, EUR_TO_JPY, EUR_TO_CNY);
                break;
            case "GBP":
                convert(amount, "GBP", GBP_TO_USD, GBP_TO_EUR, GBP_TO_JPY, GBP_TO_CNY);
                break;
            case "JPY":
                convert(amount, "JPY", JPY_TO_USD, JPY_TO_EUR, JPY_TO_GBP, JPY_TO_CNY);
                break;
            case "CNY":
                convert(amount, "CNY", CNY_TO_USD, CNY_TO_EUR, CNY_TO_GBP, CNY_TO_JPY);
                break;
            default:
                System.out.println("Неверная валюта.");
        }

        scanner.close();
    }

    private static void convert(double amount, String currency, double toEUR, double toGBP, double toJPY, double toCNY) {
        System.out.println("Сумма в " + currency + ": " + amount);
        System.out.println("Сумма в евро (EUR): " + amount * toEUR);
        System.out.println("Сумма в фунтах стерлингов (GBP): " + amount * toGBP);
        System.out.println("Сумма в японских иенах (JPY): " + amount * toJPY);
        System.out.println("Сумма в китайских юанях (CNY): " + amount * toCNY);
    }
}
