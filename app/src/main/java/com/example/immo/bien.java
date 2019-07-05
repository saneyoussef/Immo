package com.example.immo;

import android.widget.Button;

public class bien {

    private  String nom;
    private  String datee;
    private  String price;
    private  String villee;
    private  int thumbnail;

    public bien(){}

    public bien(String nomm, String dateee, String pricee , String ville , int thumbnaill){
        nom = nomm;
        datee = dateee;
        price = pricee;
        villee = ville;
        thumbnail = thumbnaill ;
    }
   public String getNom(){
        return nom ;
   }
    public String getDatee(){
        return datee ;
    }
    public String getPrice(){
        return price ;
    }
    public String getVillee(){
        return villee; }

    public int getThumbnail(){
        return thumbnail ;
    }
    public void setNom(String nomm){
        nom = nomm;
    }
    public void setDatee(String dateee){
        datee = dateee;
    }
    public void setPrice(String pricee){
        price = pricee;
    }
    public void setVillee(String ville){
        villee = ville;
    }
    public void setThumbnail(int thumbnaill){
        thumbnail = thumbnaill ;
    }



}
