package pl.leafyhome.shop.pricing;

import pl.leafyhome.shop.model.Produkt; // Musimy zaimportować klasę Produkt z innego folderu!

public class PricingEngine {

    public double obliczDynamicznaCene(Produkt produkt) {
        if (produkt.getStanMagazynowy() >= 100) {
            return produkt.getCenaBazowa() * 0.85; // 15% rabatu
        } else if (produkt.getStanMagazynowy() < 25) {
            return produkt.getCenaBazowa() * 1.10; // 10% podwyżki
        } else {
            return produkt.getCenaBazowa();
        }
    }
}
