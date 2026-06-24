package pl.leafyhome.shop.model;

public class Produkt {
    private int id;
    private String nazwa;
    private double cenaBazowa;
    private int stanMagazynowy;
    private String kategoria;

    public Produkt(int id, String nazwa, double cenaBazowa, int stanMagazynowy, String kategoria) {
        this.id = id;
        this.nazwa = nazwa;
        this.cenaBazowa = cenaBazowa;
        this.stanMagazynowy = stanMagazynowy;
        this.kategoria = kategoria;
    }

    // Gettery
    public int getId() { return id; }
    public String getNazwa() { return nazwa; }
    public double getCenaBazowa() { return cenaBazowa; }
    public int getStanMagazynowy() { return stanMagazynowy; }
    public String getKategoria() { return kategoria; }
}
