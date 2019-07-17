package com.example.immo;

public class Messageitem {

    String prom,textt,date ;
    int promphoto ;

    public  Messageitem(){}


    public Messageitem(String prom, String text, String date, int promphoto) {
        this.prom = prom;
        this.textt = text;
        this.date = date;
        this.promphoto = promphoto;
    }

    public void setName(String name) {
        this.prom = name;
    }

    public void setText(String text) {
        this.textt = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPromphoto(int promphoto) {
        this.promphoto = promphoto;
    }

    public String getName() {
        return prom;
    }

    public String getText() {
        return textt;
    }

    public String getDate() {
        return date;
    }

    public int getPromphoto() {
        return promphoto;
    }
}
