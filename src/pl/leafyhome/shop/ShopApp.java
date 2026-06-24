package pl.leafyhome.shop;

import pl.leafyhome.shop.model.Produkt;
import pl.leafyhome.shop.pricing.PricingEngine;
import pl.leafyhome.shop.recommendation.RecommendationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopApp {
    public static void main(String[] args) {
        // 1. Inicjalizacja silnika cen i serwisu AI (Groq/Llama)
        PricingEngine pricingEngine = new PricingEngine();
        RecommendationService recommendationService = new RecommendationService(pricingEngine);

        // 2. Tworzenie bazy produktów (Z poprawną kolejnością: id, nazwa, cena, stanMagazynowy, kategoria)
        List<Produkt> bazaProduktow = new ArrayList<>();
        bazaProduktow.add(new Produkt(1, "Doniczka plastikowa oddychająca", 12.50, 15, "Dom i ogród"));
        bazaProduktow.add(new Produkt(2, "Nawóz do monstery", 24.99, 50, "Pielęgnacja"));
        bazaProduktow.add(new Produkt(3, "Lepy na muszki owocówki", 8.99, 100, "Ochrona"));
        bazaProduktow.add(new Produkt(4, "Ziemia uniwersalna 10L", 18.00, 0, "Podłoża"));

        // 3. Inicjalizacja Scannera do czytania z konsoli
        Scanner wejscie = new Scanner(System.in);

        System.out.println("=== INTERAKTYWNY ASYSTENT SKLEPU LEAFY HOME ===");

        // 4. Główna pętla programu
        while (true) {
            System.out.println("\nWpisz swój problem z roślinami (lub wpisz 'nie' / 'wyjście', aby zamknąć program):");
            System.out.print("Twój problem: ");

            String pytanieKlienta = wejscie.nextLine().trim();

            // Warunek wyjścia z pętli i zakończenia programu
            if (pytanieKlienta.equalsIgnoreCase("nie") ||
                    pytanieKlienta.equalsIgnoreCase("wyjście") ||
                    pytanieKlienta.isEmpty()) {

                System.out.println("\nDziękujemy za skorzystanie z asystenta sklepu Leafy Home. Do zobaczenia!");
                break; // Przerywa pętlę while, co kończy działanie programu
            }

            System.out.println("\n[Łączenie z AI (Groq/Llama)... Proszę czekać]");

            // 5. Wysłanie pytania do AI
            try {
                String odpowiedz = recommendationService.pobierzRekomendacjeOdAI(pytanieKlienta, bazaProduktow);
                System.out.println("\n" + odpowiedz);

                // Komunikat zachęcający do dalszej rozmowy
                System.out.println("\n--------------------------------------------------");
                System.out.println("Czy chcesz zadać jeszcze jakieś pytanie? Wpisz je śmiało!");
                System.out.println("--------------------------------------------------");

            } catch (Exception e) {
                System.out.println("Wystąpił błąd podczas generowania odpowiedzi: " + e.getMessage());
                e.printStackTrace();
                System.out.println("\nMożesz spróbować zadać pytanie ponownie.");
            }
        }

        // Zamykamy scanner po wyjściu z pętli
        wejscie.close();
    }
}