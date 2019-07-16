package com.example.immo.Models;

import java.util.Date;

public class AnnonceResponse {
    private Location location;
    private Category category;
    private Atout atouts;
    private Double prix;
    private  String description;
    private Date dateDeLivraison;
    private String urlVideo;
    private int rating;

    public AnnonceResponse() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Atout getAtouts() {
        return atouts;
    }

    public void setAtouts(Atout atouts) {
        this.atouts = atouts;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDeLivraison() {
        return dateDeLivraison;
    }

    public void setDateDeLivraison(Date dateDeLivraison) {
        this.dateDeLivraison = dateDeLivraison;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public enum Atout {
        ESPACE_VERT,
        CLIMATISATION,
        CAM_SURVEILLANCE,
        CHAUFFAGE,
        ASCENCEUR,
        PARKING
    }

    public enum Category {
        VILLA,
        APPARTEMENT,
        BUREAU,
        TERRAIN,
        CABINET,
        COMMERCE
    }

}
