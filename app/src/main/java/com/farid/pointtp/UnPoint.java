package com.farid.pointtp;

public class UnPoint {
    String nom;
    String adresse;
    String memonic;
    int numero;

    public UnPoint(String nom, String adresse,
                   String memonic, int numero) {
        this.nom = nom;
        this.adresse = adresse;
        this.memonic = memonic;
        this.numero = numero;
    }

    public UnPoint(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public String getMemonic() {
        return memonic;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getNumero() {
        return numero;
    }

}
