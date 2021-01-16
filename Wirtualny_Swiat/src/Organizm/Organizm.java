package Organizm;

import Swiat.Swiat;

public abstract class Organizm {
    private int sila__;
    private int inicjatywa__;
    private int x__;
    private int y__;
    private Swiat swiat__;
    private int wiek__;
    private boolean zyje__;

   public Organizm(){
       this.wiek__ = 0; //Kazdy nowy organizm ma startowy wiek = 0
       this.zyje__ = true; // Kazdy nowy organizm zyje
    }
    public abstract void akcja(); // określa zachowanie organizmu w trakcie tury

    public abstract void rysowanie(); // powduje narysowanie symbolicznej reprezentacji orgnizmu

    public abstract boolean reakcja(Organizm przeciwnik); // reakcja organizmu na atak

    public void kolizja(Organizm organizm) {}; // określa zachowanie organizmu w trakcie kontaktu/zderzenia z innym organizmem



    public Swiat getSwiat__() {
        return swiat__;
    }

    public void setZyje__(boolean zyje__) {
        this.zyje__ = zyje__;
    }
    public boolean getZyje__(){
        return this.zyje__;
    }

    protected void setSila__(int sila__) {
        this.sila__ = sila__;
    }

    protected void setInicjatywa__(int inicjatywa__) {
        this.inicjatywa__ = inicjatywa__;
    }

    protected void setX__(int x__) {
        this.x__ = x__;
    }

    protected void setY__(int y__) {
        this.y__ = y__;
    }


    protected void setSwiat__(Swiat swiat__) {
        this.swiat__ = swiat__;
    }

    public int getSila__() {
        return sila__;
    }

    public int getInicjatywa__() {
        return inicjatywa__;
    }

    public int getX__() {
        return x__;
    }

    public int getY__() {
        return y__;
    }

    public int getWiek__() {
        return wiek__;
    }
    public void zwiekszWiek(){
        this.wiek__ += 1;
    }

    public void setWiek__(int wiek__) {
        this.wiek__ = wiek__;
    }
}





