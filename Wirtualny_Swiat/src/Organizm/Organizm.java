package Organizm;

import Swiat.Swiat;

public abstract class Organizm {
    private int sila;
    private int inicjatywa;
    private int x;
    private int y;
    private Swiat swiat;

    public abstract void akcja(); // określa zachowanie organizmu w trakcie tury
    public abstract void kolizja(); // określa zachowanie organizmu w trakcie kontaktu/zderzenia z innym organizmem
    public abstract void rysowanie(); // powduje narysowanie symbolicznej reprezentacji orgnizmu
    protected void setSila(int sila){
        this.sila = sila;
    }
    protected void setInicjatywa(int inicjatywa){
        this.inicjatywa = inicjatywa;
    }
    protected void setX(int x){
        this.x = x;
    }
    protected void setY(int y){
        this.y = y;
    }
    protected void setSwiat(Swiat swiat){
        this.swiat = swiat;
    }
    protected int getSila(){
        return sila;
    }

    public int getInicjatywa() {
        return inicjatywa;
    }
}


