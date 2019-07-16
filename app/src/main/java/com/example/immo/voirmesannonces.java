package com.example.immo;

public class voirmesannonces {

    private  String nom;
    private  int thumbnail;

    public voirmesannonces(){}

    public voirmesannonces(String nomm, int thumbnaill){
        nom = nomm;
        thumbnail = thumbnaill ;
    }
   public String getNom(){
        return nom ;
   }
    public int getThumbnail(){
        return thumbnail ;
    }
    public void setNom(String nomm){
        nom = nomm;
    }
    public void setThumbnail(int thumbnaill){
        thumbnail = thumbnaill ;
    }



}
