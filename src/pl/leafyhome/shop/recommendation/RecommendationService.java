package pl.leafyhome.shop.recommendation;

import dev.langchain4j.model.openai.OpenAiChatModel; // Używamy standardu OpenAI
import pl.leafyhome.shop.model.Produkt;
import pl.leafyhome.shop.pricing.PricingEngine;
import java.util.List;

public class RecommendationService {

    private final PricingEngine pricingEngine;
    private final OpenAiChatModel modelAI;

    public RecommendationService(PricingEngine pricingEngine) {
        this.pricingEngine = pricingEngine;

        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("BŁĄD: Brak klucza w zmiennych środowiskowych!");
        }

        // Konfiguracja połączenia z darmowymi i ultraszybkimi serwerami Groq
        this.modelAI = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .baseUrl("https://api.groq.com/openai/v1") // <--- To przekierowuje nas do Groq!
                .modelName("llama-3.3-70b-versatile")      // <--- Świetny, darmowy model Llama 3.3
                .temperature(0.7)
                .build();
    }

    public String generujKontekstProduktow(List<Produkt> baza) {
        StringBuilder sb = new StringBuilder();
        sb.append("Dostępne produkty w sklepie Lux:\n");

        for (Produkt p : baza) {
            double aktualnaCena = pricingEngine.obliczDynamicznaCene(p);
            sb.append(String.format("- ID: %d | %s | Cena: %.2f zł | Kategoria: %s (Na stanie: %d)\n",
                    p.getId(), p.getNazwa(), aktualnaCena, p.getKategoria(), p.getStanMagazynowy()));
        }
        return sb.toString();
    }

    public String pobierzRekomendacjeOdAI(String pytanieKlienta, List<Produkt> baza) {
        String kontekstSklepu = generujKontekstProduktow(baza);

        String pelnyPrompt = """
                === INSTRUKCJA SYSTEMOWA ===
                Jesteś profesjonalnym i pomocnym doradcą w sklepie internetowym LEAFY HOME.
                Twoim zadaniem jest przeanalizować problem klienta i polecić mu maksymalnie 2 odpowiednie produkty z listy.
                Zawsze podawaj aktualną cenę z listy i odnoś się do problemu klienta. Buduj przyjazne odpowiedzi marketingowe.
                
                === KONTEKST PRODUKTOWY APLIKACJI ===
                """ + kontekstSklepu + """
                
                === ZAPYTANIE KLIENTA ===
                """ + pytanieKlienta;

        String odpowiedzOdGeneratywnegoAI = modelAI.generate(pelnyPrompt);

        return  odpowiedzOdGeneratywnegoAI;
    }
}