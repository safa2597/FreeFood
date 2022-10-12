package com.example.freefood;

public class Restaurant {
    int id,imageId,contact;
    String nom,localisation,mail,description;
    boolean livraison;

    public Restaurant(int id, int imageId, String nom, String localisation, String mail, int contact, String description, boolean livraison) {
        this.id = id;
        this.imageId = imageId;
        this.nom = nom;
        this.localisation = localisation;
        this.mail = mail;
        this.contact = contact;
        this.description = description;
        this.livraison = livraison;
    }
}
