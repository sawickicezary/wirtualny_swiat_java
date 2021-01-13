package Swiat;

import Organizm.Organizm;
import Organizm.Roslina.Ciern;
import Organizm.Zwierze.Zolw;

public class Swiat {
    private Organizm[] organizmy = {new Ciern(this, 3, 4)};

    public void wykonajTure(){
        for (Organizm organizm:
             organizmy) {
            organizm.akcja();
        }
    }
    public void rysujSwiat(){

    }

    public static void main(String[] args) {
        Swiat swiat = new Swiat();
        swiat.wykonajTure();
    }
}
